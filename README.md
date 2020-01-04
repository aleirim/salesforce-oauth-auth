# Salesforce integration example (oauth2 web-server flow)

Example to obtain a salesforce access token using [Salesforce REST API](https://developer.salesforce.com/docs/atlas.en-us.api_rest.meta/api_rest/quickstart_oauth.htm). The [web server flow](https://developer.salesforce.com/docs/atlas.en-us.api_rest.meta/api_rest/intro_understanding_web_server_oauth_flow.htm) consists in authorizing a third-party system.

##Prerequisites
1- [Obtain a salesforce developer edition](https://developer.salesforce.com/signup)

2- [Create a connected app](https://help.salesforce.com/articleView?id=connected_app_create.htm): 

- From Setup, enter Apps in the Quick Find box, and select App Manager.
- Click New Connected App.
- Enter the connected app’s name, which displays in the App Manager and on its App Launcher tile. The connected app name must be unique within your org. If the connected app was created in the Spring ‘14 release or later, you can reuse the name of a deleted connected app.
- Click Enable OAuth Settings and specify your callback URL and OAuth scopes. The Callback URL you supply here is the same as your application’s callback. It must be secured. For development environments, the callback URL is similar to https://localhost:8443/...
- this is a test


## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Usage

```python
import foobar

foobar.pluralize('word') # returns 'words'
foobar.pluralize('goose') # returns 'geese'
foobar.singularize('phenomena') # returns 'phenomenon'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/