-- найти наименее занятого бегущего по лезвию
CREATE
OR REPLACE FUNCTION find_blade_runner(blade_runners_hq_id integer)
    returns
        integer
as
$$
DECLARE
res integer := 0;
BEGIN
    res
= (select br.id
           from replicant_search
                    join blade_runner br
                         on br.id = replicant_search.blade_runner_id
           where hq_id = blade_runners_hq_id
             and result is null
           group by br.id
           order by count(*)
           limit 1);
return res;
END
$$
LANGUAGE plpgsql;

--посчитать результат теста
CREATE
OR REPLACE FUNCTION calculate_test_result(vkt_id integer) returns boolean as
$$
DECLARE
all_answ float := 0;
    right_answ
float := 0;
    res
float := 0;
    p
float   := 0.6;
BEGIN
    all_answ
= (select count(*)
                from voight_kampf_test_answers
                where voight_kampf_test_id
                          = vkt_id);
    right_answ
= (select count(*)
                  from voight_kampf_test_answers
                  where voight_kampf_test_id = vkt_id and result = true);
    res
= all_answ * p;
    if
(right_answ >= res) then
        return true;
else
        return false;
end if;
END
$$
LANGUAGE plpgsql;

-- определить модель репликанта
create function define_replicant_model(birth_date date) returns integer
    language plpgsql
as
$$
DECLARE
year_nexus6  date
        := '2019-01-01';
    year_nexus8
date
        := '2020-01-01';
    year_blacout
date
        := '2022-01-01';
    year_nexus9
date
        := '2036-01-01';
BEGIN
    IF
(birth_date is null) then
        return null;
end if;
    IF
(birth_date <= year_nexus6) then
        return (select id from replicant_model where name = 'Nexus 6');
end if;
    IF
(birth_date > year_nexus6 and birth_date < year_nexus8) then
        return (select id from replicant_model where name = 'Nexus 7');
end if;
    IF
(birth_date >= year_nexus8 and birth_date <= year_blacout) then
        return (select id from replicant_model where name = 'Nexus 8');
end if;
    IF
(birth_date > year_blacout and birth_date < year_nexus9) then
        return null;
end if;
    IF
(birth_date >= year_nexus9) then
        return (select id from replicant_model where name = 'Nexus 9');
end if;
return null;
END
$$;

-- определить является ли репликантом
create function is_replicant(entity_id integer) returns boolean
    language plpgsql
as
$$
DECLARE
res boolean;
BEGIN
    res
= (select is_human from entity where id = entity_id);
    IF
res then
        return false;
else
        return true;
end if;
END
$$;

-- найти ближайший штаб бегущих по лезвию
CREATE OR REPLACE FUNCTION nearest_HQ(location_id integer) returns integer as
$$
DECLARE
n          integer := 1;
    nearest_id integer := 0;
    n_lat
float
                       := 0;
    n_long
float
                       := 0;
    max_lat
float
                       := 0;
    max_long
float
                       := 0;
    lat
float
                       := 0;
    long
float
                       := 0;
BEGIN
    if (location_id is not null) then
        n = (select max(id) from blade_runners_hq);
        n_lat = (select latitude from location where id = location_id);
        n_long = (select longitude from location where id = location_id);
        max_lat = (select max(latitude) from location);
        max_long = (select max(longitude) from location);

        LOOP
lat = (select latitude
                   from location
                            join
                        blade_runners_hq b on location.id = b.location_id where b.id = n);
            long = (select longitude
                    from location
                             join
                         blade_runners_hq brh on location.id = brh.location_id  where brh.id = n);
            if @ (lat - n_lat) <= max_lat and @(long - n_lat) <= max_long then
                max_lat = lat;
                max_long = long;
                nearest_id = n;
end if;
            n = n - 1;
            EXIT WHEN n = 0;
end loop;
else
        nearest_id = (select id from blade_runners_hq limit 1);
end if;
return nearest_id;
END
$$ LANGUAGE plpgsql;