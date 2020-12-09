# hr-project
Spring boot (RestfullAPI)

Technologies<br>
Mandatory
⦁ PostgreSQL Database <br>
⦁ Spring Web<br>
⦁ Spring Data JPA<br>
⦁ Spring Security<br>
⦁ JWT<br>
⦁ Swagger<br>
⦁ Postman(Testing)<br>
⦁ Build Tool (i.e. Maven) <br>

## Instructions To Run Backend
1- Just Extract The BACKEND Folder to STS(Spring Tool Suite) and run it as (Java Application) on port=8080.<br>
2- For Database You can Excute the sql file in your Sql Editor (it contain database creation statement) OR Just create the database(name=hr,username=postgres,pass=adminadmin) Maunally And Run The Application And It will create the Tables With It Objects.<br>
3- Then You Can Test It Using Postman.<br>

== AppUser ==<br>
Login(POST:localhost:8080/api/v1/auth/login?userName=admin&password=admin)<br>
Login(POST:localhost:8080/api/v1/auth/login?userName=user&password=user)<br>

== Employee ==<br>
Return all Employees (GET : localhost:8080/api/v1/getAllEmps)<br>
Return Employee (GET : localhost:8080/api/v1/getById/{id}) <br>
Return Employee (GET : localhost:8080/api/v1/getById) With Request Param <br>
Add Employee (POST : localhost:8080/api/v1/addEmp) With Json Body <br>
Update Employee (PUT : localhost:8080/api/v1/updateEmp) With Json Body <br>
Delete Employee (DELETE : localhost:8080/api/v1/deleteEmp) With Request Param <br>

== Depatment == <br>
Return all Depatment (GET : localhost:8080/api/v1/getAllDepts) <br>
Return Depatment (GET : localhost:8080/api/v1/getDeptById) With Request Param <br>
Add Depatment (POST : localhost:8080/api/v1/addDept) With Json Body <br>
Update Depatment (PUT : localhost:8080/api/v1/updateDept) With Json Body <br>
Delete Depatment (DELETE : localhost:8080/api/v1/deleteDept) With Request Param <br>

== Relation Between Employees And Department == <br>
Return all Employees bassed on Department (GET : localhost:8080/getAllDepts/{deptId}/getAllEmps) <br>

