# Datwyler Assignment

----

## Github repos

1. Kotlin Springboot Backend  
   <https://github.com/nghaninn/datwyler-backend-springboot> (this repo)
   - [Cloud Run Endpoint](https://datwyler-assignment-fqiihixc7a-de.a.run.app)
   - [Postman RestAPI](https://www.postman.com/bold-rocket-440422/workspace/datwyler-assignment/folder/23709222-034fc302-c879-4959-ac62-42fd6d8eb59f?ctx=documentation)
2. React Frontend  
   <https://github.com/nghaninn/datwyler-frontend>
   - [Frondend URL](https://www.datwyler.nghaninn.com/)

----

## Steps to start project

### **1. Kotlin Springboot Backend**

*CICD handled by github actions, triggeres on tag created.*  
Running on in memory DB.

```bash
docker build -t datwyler-nghaninn .
docker run -p 8080:8080 -t datwyler-nghaninn
```

### **2. React Frontend**

Build using ant design.  
*CICD handled by Amplify, linked with Github, triggers on push*

```bash
yarn install
yarn start

username: admin
password: password
```

----

## Database Table

1. Applicant
2. Account
3. Loan

----

# Questions

## Challenges Faced

>1. Integrating with third party oauth
>2. Frontend refresh error, yet to solve.

## Unable to accomplished

>1. Account creation, use default account listed above.

----