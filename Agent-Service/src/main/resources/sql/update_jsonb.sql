-- Column: public.agent.address

-- ALTER TABLE IF EXISTS public.agent DROP COLUMN IF EXISTS address;

ALTER TABLE IF EXISTS public.agent
    ADD COLUMN address JSONB;