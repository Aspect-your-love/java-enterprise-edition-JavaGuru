package net.aspect.education.hibernate;

public class HibernateRunnerTest {

    /*@Test
    public void testHIbernateApi() throws SQLException, IllegalAccessException {
        User user = User.builder()
                .username("kulagin1@developer.ru")
                .firstName("Viktor")
                .lastname("Kulagin")
                .birthDate(new Birthday(LocalDate.of(2001, 1, 1)))
                .role(Role.ADMIN)
                .build();

        String sql = """
                insert into 
                %s
                (%s)
                values
                (%s)
                """;

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(tabAnn -> tabAnn.schema() + "." + tabAnn.name())
                .orElse(user.getClass().getName());

        Field[] fields = user.getClass().getDeclaredFields();

        String columnName = Arrays
                .stream(fields)
                .map(field -> Optional
                        .ofNullable(field
                                .getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(Collectors.joining(", "));

        String columnValues = Arrays.stream(fields)
                .map(field -> "?")
                .collect(Collectors.joining(", "));

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/hibernate"
                        ,"postgres"
                , "root");
        PreparedStatement preparedStatement = connection
                .prepareStatement(sql.formatted(tableName
                        , columnName
                        , columnValues));

        for(int i = 0; i < fields.length; i++){
            fields[i].setAccessible(true);
            preparedStatement.setObject(i+1, fields[i].get(user));
        }

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }*/
}
