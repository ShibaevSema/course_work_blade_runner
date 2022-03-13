CREATE INDEX idx_child_id on descendants using hash(child_id);
CREATE INDEX Idx_vkt_answer_res ON voight_kampf_test_answers USING hash(result);
CREATE INDEX Idx_entity_id ON entity USING hash(ID);
CREATE INDEX Idx_is_human ON entity USING hash(IS_HUMAN);
CREATE INDEX Idx_ben ON action USING hash(benefitorharm);
CREATE INDEX Idx_impact_on_s ON impact_on_society USING hash(entity_id);