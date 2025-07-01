CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE teams (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    team_name VARCHAR(255) NOT NULL UNIQUE,
    score INTEGER,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    modified_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_teams_user
        FOREIGN KEY(user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE players (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    team_player_join_id VARCHAR(255) NOT NULL UNIQUE,
    points INTEGER,
    cost INTEGER,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    modified_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_players_user
        FOREIGN KEY(user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE player_team_join (
    player_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,

    CONSTRAINT fk_player
        FOREIGN KEY(player_id)
        REFERENCES players(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_team
        FOREIGN KEY(team_id)
        REFERENCES teams(id)
        ON DELETE CASCADE,

    PRIMARY KEY(player_id, team_id)
);

CREATE TABLE leagues (
    id BIGSERIAL PRIMARY KEY,
    league_name VARCHAR(255) NOT NULL,
    budget NUMERIC(10, 2) NOT NULL DEFAULT 100.00,
    owner_id BIGINT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_league_owner
        FOREIGN KEY(owner_id)
        REFERENCES users(id)
);
