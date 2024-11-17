# GrowthX
User Management Spring boot application
Register User
Endpoint: POST /api/users/register
json
{
  "username": "akash101",
  "password": "akash101"
}
------------------------------------------------
User Login
Endpoint: POST /api/users/login
json
{
  "username": "akash101",
  "password": "akash101"
}
---------------------------------------------------
Upload Assignment
Endpoint: POST /api/users/upload
json
{
  "userId": "akash101",
  "task": "Task 1",
  "admin": "AKASH000"
}
------------------------------------------------------
Fetch All Admins
Endpoint: GET /api/users/admins
-----------------------------------------------------
Register Admin
Endpoint: POST /api/admin/register
json
{
  "username": "AKASH000",
  "password": "AKASH000"
}
----------------------------------------------------
Admin Login
Endpoint: POST /api/admin/login
json
{
  "username": "AKASH000",
  "password": "AKASH000"
}
---------------------------------------------------
View Assignments for Admin
Endpoint: GET /api/admin/assignments
---------------------------------------------------
Accept Assignment
Endpoint: POST /api/admin/assignments/{id}/accept
----------------------------------------------------
Reject Assignment
Endpoint: POST /api/admin/assignments/{id}/reject
----------------------------------------------------
And at last in application.properties file give your mongodb database name
