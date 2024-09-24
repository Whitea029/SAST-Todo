CREATE TABLE User(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(10) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Task(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status TINYINT NOT NULL DEFAULT 0 COMMENT '0:待完成，1:已完成，2:进行中，3:已取消',
    due_date DATE,
    create_time DATETIME,
    last_update_time DATETIME
);