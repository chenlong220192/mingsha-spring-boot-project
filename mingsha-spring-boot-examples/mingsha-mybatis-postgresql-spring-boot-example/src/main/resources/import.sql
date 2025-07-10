DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  email VARCHAR(128),
  phone VARCHAR(32),
  age INT,
  address VARCHAR(128),
  create_time TIMESTAMP,
  update_time TIMESTAMP
);

INSERT INTO users (username, email, phone, age, address, create_time, update_time) VALUES
('张三', 'zhangsan@example.com', '13800138000', 25, '北京市朝阳区', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('李四', 'lisi@example.com', '13800138001', 30, '上海市浦东新区', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('王五', 'wangwu@example.com', '13800138002', 28, '广州市天河区', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 