# DSI Practice 3

Using what we have seen in practice/Lab class, we are asked to implement the following web page using Angular and Custom Components. As can be seen, the page allows the user to select an option from a list of Autonomous Communities, as well as a list of Provinces belonging to the selected Autonomous Community.

The micro-practice is requested by defining Custom Elements for the Community and Province selectors; these Custom Elements will have a numeric attribute id that serves as a unique identifier.

When the user selects an Autonomous Community, the list of Provinces is automatically updated.

Finally, when the user clicks on the button shown at the bottom of the page, the id of the current Community and Province is displayed.

The following structure is suggested:

```Angular
<app-select2 [(values)]="values" (changed)="changed_lists($event)" label1="Community" label2="Province">
<app-option2 id="1" text="Castilla y León" ></app-option2>
<app-option2 id="2" text="Ávila" idParent="1"></app-option2>
...
<app-option2 id="8" text="Madrid"></app-option2>
<app-option2 id="9" text="Madrid" idParent="8"></app-option2>
...
</app-select2>
```

As you can see, in this example we have defined a parent custom element that contains all the options and paints the two selectors using the tags defined as attributes; the child custom element defines one of the options that can be included inside one of the two selectors, depending if the idParent attribute exists or not, i.e. if it has an idParent parameter, it is a province, otherwise it is an autonomous community.

## Deploy in GitHub Pages

There is no need to create the branch, it creates itself.

Once the repository is created with everything in GitHub.

```terminal
ng add angular-cli-ghpages
ng deploy --base-href=/<repositoryname>/
```
