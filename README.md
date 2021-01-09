# ItunesSearch #

itunesSearch is a Jira plugin to search apple Itunes store for artists and return results via REST API endpoint.

## Installation #

First of all, you you need to install
[atlassian SDK.](https://developer.atlassian.com/server/framework/atlassiansdk/downloads/)

Here are the SDK commands you'll use immediately (commands must be run in plugin folder):

* ```atlas-run``` -- installs this plugin into the product and starts it on localhost
* ```atlas-debug``` -- same as atlas-run, but allows a debugger to attach at port 5005
* ```atlas-help``` -- prints description for all commands in the SDK

Full documentation is always available at
[Introduction to the atlassian plugin SDK](https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK)

## Usage #

You can use [The Postman](https://www.postman.com/downloads/) or any other program to send ```GET``` requests and view
responses.

After running atlassian, you could
send ```GET <your-local-jira-url>/rest/searchresource/1.0/message/1.0/artists?=<artists>``` request and
get [JSON](https://www.json.org/) formatted response. in ```<artists>``` you can input your  search object.

Request example:  ```GET <your-local-jira-url>/rest/searchresource/1.0/message/1.0/artists?=sylosis```

Response example: ```
[
{
    "name": Sylosis
    "link": "https://music.apple.com/us/artist/sylosis/191950242?uo=4",
    "id": 191950242,
    "genre": "Metal",
    "genreId": 1153
}
]```