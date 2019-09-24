
This library exposes an Spring Cloud OpenFeign implementation for Alfresco V1 Rest APIs.
You can add it to your dependencies and use it in a Spring Boot application for instance.
Spring Boot autoconfiguration is used and therefore no manual configuration is required.

You can use the library as some kind of aggregator or proxy to your ACS instance. An HTTP proxy like
Apache/NGINX or a Tuckey web filter could be used to proxy the requests.

Maven (on Maven Central)
--
```
  <dependency>
    <groupId>com.pleosoft</groupId>
    <artifactId>acs-feign-client</artifactId>
    <version>1.0.0-RELEASE</version>
  </dependency>
```

in application.properties
--
defaults are:
```
  acs.feign.defaultAuthorization=
  acs.feign.authorizationHeaderName=Authorization
  acs.feign.url=
```

defaultAuthorization will only be used if authorizationHeaderName is missing a header value
however, both cannot be empty.

If you want to specify a default Authorization like admin:admin,
than you can use acs.feign.defaultAuthorization and set to Basic Authorization like this
- acs.feign.defaultAuthorization = Basic YWRtaW46YWRtaW4=
(YWRtaW46YWRtaW4= is a base64 representation of admin:admin)

ADF and Keycloack/AIS (Alfresco Identity Services) use a JWT and send it through the
Aturhotization header name, if for some reason you want to customize the header name use
- acs.feign.authorizationHeaderName=MY_HEADER

Finally, specify your ACS (Alfresco Content Services) host:
- acs.feign.url=http://localhost:8080/alfresco


Enable all APIs
- acs.feign.use-defaults=true
should be added to your applicaiton.properties

Cherrypick the APIs you need
- @EnableFeignClients(clients = { NodesApiClient.class })
add this annotation to your spring configuration in order to enable NodesApi. You can use any API listed below

in your java classes
--
```
	@Autowired
	private NodesApiClient nodesApiClient;

	...
	final NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
		nodeBodyCreate.setName("test-swagger3.txt");
		nodeBodyCreate.setNodeType("cm:content");
		final ResponseEntity<NodeEntry> createNode = nodesApiClient.createNode("-root-", nodeBodyCreate, false, null, null);
	...
```

API beans you can use
--
```
  AuthenticationApiClient
  ActionsApiClient
  ActivitiesApiClient
  AuditApiClient
  CommentsApiClient
  DownloadsApiClient
  FavoritesApiClient
  GroupsApiClient
  NetworksApiClient
  NodesApiClient
  PeopleApiClient
  PreferencesApiClient
  ProbesApiClient
  QueriesApiClient
  RatingsApiClient
  RenditionsApiClient
  SharedLinksApiClient
  SitesApiClient
  TagsApiClient
  TrashcanApiClient
  VersionsApiClient
  DiscoveryApiClient
  SearchApiClient
  SqlApiClient
  DeploymentsApiClient
  ProcessDefinitionsApiClient
  ProcessesApiClient
  TasksApiClient
```

ADF
--
a webscript call could be sent to your spring controller and the response would match what is expected, but instead of using Alfresco People API
you could do a search and only show the groups/people you need for your custom logic and still use ADF components.

```
 this.apiService.getInstance().webScript.executeWebScript(
      'GET',
      'people',
      [],
      null,
      'pleo',
      null
    ).then(
      (response: any) => {
        let results = [];
        for (var entry of response.list.entries) {
          results.push({
            id: entry.entry.id,
            firstName: entry.entry.firstName,
            lastName: entry.entry.lastName,
            status: 'green',
            icon: 'material-icons://accessibility'
          });
        }
        this.data.setRows(results.map(item => { return new ObjectDataRow(item); }));
      }
    );
```
