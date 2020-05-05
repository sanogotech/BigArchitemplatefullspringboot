https://hellokoding.com/database-migration-evolution-with-flyway-and-jpa-hibernate/
https://github.com/sanogotech/hellokoding-courses/tree/master/springboot-examples/springboot-flyway
#How Flyway works
Flyway applies migration scripts to the underlying database in the order based on the version number specified in the script file naming

At each execution, only pending migrations are applied. Flyway manages this via creating (if not exists) and updating a metadata table. You can find more details about this table in the latter part of this tutorial

The migration scripts can not be changed after applied. Flyway compares the checksum of each script in every execution and throws an exception if there's a mismatch