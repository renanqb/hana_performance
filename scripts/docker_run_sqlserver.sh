#!/bin/bash

PASSWORD='!234Abcd'
echo "Running > docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=$PASSWORD' -e 'MSSQL_PID=Express' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest-ubuntu"
docker run -e 'ACCEPT_EULA=Y' -e "SA_PASSWORD=$PASSWORD" -e 'MSSQL_PID=Express' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest-ubuntu

echo "-----------------------------------------------------"

sleep 1.5
CONTAINER_ID=$(docker ps -q)
echo "Running > docker exec -it $CONTAINER_ID /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $PASSWORD"
docker exec -it $CONTAINER_ID /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $PASSWORD
