# ItunesSearch #

itunesSearch is a Jira plugin to search apple Itunes store for artists and return results via REST API endpoint.

## Installation #

1. First of all, you need to install
   [atlassian SDK.](https://developer.atlassian.com/server/framework/atlassian-sdk/downloads/)
2. Clone this repository ```gh repo clone LinasJu/itunesSearch```
3. Inside cloned directory, you can run these SDK commands:
    * ```atlas-run``` -- installs this plugin into the product and starts it on localhost
    * ```atlas-debug``` -- same as atlas-run, but allows a debugger to attach at port 5005
    * ```atlas-help``` -- prints description for all commands in the SDK.

   Full documentation is always available at
   [Introduction to the atlassian plugin SDK](https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK)

## Usage #

You can use [The Postman](https://www.postman.com/downloads/) or any other program that can send ```GET``` requests and
view responses.

After running atlassian and starting plugin, you can
send ```GET <your-local-jira-url>/rest/searchresource/1.0/message/1.0/artists?=<artists>``` request and
get [JSON](https://www.json.org/) formatted response. In ```<artists>``` you can input your search object.

Request example:

```GET <your-local-jira-url>/rest/searchresource/1.0/message/1.0/artists?=sylosis```

Response example:

```json
[
  {
    "name": "Sylosis",
    "link": "https://music.apple.com/us/artist/sylosis/191950242?uo=4",
    "id": 191950242,
    "genre": "Metal",
    "genreId": 1153
  }
]
```