package me.parker.springjpapostgresql.containers;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresqlTestContainers extends PostgreSQLContainer<PostgresqlTestContainers> {
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static PostgresqlTestContainers container;

    private PostgresqlTestContainers() {
        super(IMAGE_VERSION);
    }

    public static PostgresqlTestContainers getInstance() {
        if (container == null) {
            container = new PostgresqlTestContainers();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
