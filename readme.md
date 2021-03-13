# docker 
```
docker run -d -p 27017:27017 --name mongodb -v /home/max/dev/mongodb/data/db:/data/db mongo
```
# test
## curl
```
curl localhost:8080/movies | jq
curl localhost:8080/movies/604cd496ceb0dd0acb9a1111/events
```