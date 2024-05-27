CREATE TABLE IF NOT EXISTS products (
    product_id      BIGSERIAL PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    account_number  BIGINT NOT NULL,
    account_balance NUMERIC(10,2) CONSTRAINT account_balance_positive CHECK (account_balance >= 0),
    product_type    VARCHAR(10)
);

