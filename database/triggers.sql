-- В таблице Human: birth_date < death_date
CREATE
OR REPLACE FUNCTION correct_date_of_birth() RETURNS TRIGGER as
$$
BEGIN
IF
new.birth_date < new.death_date or
new.birth_date = new.death_date or
new.birth_date is null or
new.death_date is null THEN
RETURN NEW;
ELSE
RAISE EXCEPTION 'Invalid birth_date/death_date';
END IF;
END;
$$
LANGUAGE plpgsql;
CREATE TRIGGER TRIGGER_correct_date_of_birth
    BEFORE INSERT OR
UPDATE ON ENTITY
    FOR EACH ROW EXECUTE PROCEDURE correct_date_of_birth();

-- В таблице Replicants может быть только Entity, у которого is_human = false
CREATE
OR REPLACE FUNCTION replicant_not_human() returns trigger as
$$
DECLARE
res bool := false;
BEGIN
    IF
res = (select is_human from entity where entity.id = new.entity_id) THEN
        RAISE EXCEPTION 'replicant cant be a human ';
ELSE
        RETURN NEW;
END IF;
END
$$
LANGUAGE plpgsql;
CREATE TRIGGER TRIGGER_replicant_not_human
    BEFORE INSERT OR
UPDATE
    ON replicant
    FOR EACH ROW
    EXECUTE PROCEDURE replicant_not_human();

-- Нужно вести статистику по новым репликантам -

create function find_replicants() returns trigger
    language plpgsql
as
$$
DECLARE
n
        integer := 0;
    n_br_id
integer := 0;
    hq
integer := 0;
    replicant
integer := 0;
    l_id
integer := 0;
    model_nexus9_id
integer := 0;
    model_nexus6_id
integer := 0;
    lifetime
integer := 1000;

BEGIN
    if
(new.is_human = false) then
        if (new.death_date is null) then
            n = (select define_replicant_model(new.birth_date));
            model_nexus9_id
= (select id from replicant_model where name = 'Nexus 9');
            model_nexus6_id
= (select id from replicant_model where name = 'Nexus 6');
            if
(n = model_nexus9_id) then
                insert into replicant(entity_id, replicant_model_id, lifespan) values (new.id, n, 1000);
else
                if (n = model_nexus6_id) then
                    lifetime = 4;
else
                    lifetime = 1000;
end if;
insert into replicant(entity_id, replicant_model_id, lifespan)
values (new.id, n, lifetime);
l_id
= new.location_id;
                hq
= (select nearest_hq(l_id));
                if
(
select id
from blade_runner
where hq_id = hq
  and free = true
    limit 1) is not null
                then
                    n_br_id = (
select id
from blade_runner
where hq_id = hq
  and free = true
    limit 1);

UPDATE blade_runner SET free = false where id = n_br_id;

replicant
= (select max(id) from replicant);
insert into replicant_search(blade_runner_id, replicant_id,
                             result)
values (n_br_id, replicant, null);
else
                    n_br_id = (select find_blade_runner(hq));
                    replicant
= (select max(id) from replicant);

                    if n_br_id is null then
                        n_br_id = (select * from BLADE_RUNNER where HQ_ID = hq limit 1);
end if;

insert into replicant_search(blade_runner_id, replicant_id,
                             result)
values (n_br_id, replicant, null);
end if;
end if;
end if;
end if;
return new;
END
$$;

CREATE TRIGGER TRIGGER_find_REPLICANTS
    AFTER INSERT OR
UPDATE
    ON ENTITY
    FOR EACH ROW
    EXECUTE PROCEDURE find_REPLICANTS();
