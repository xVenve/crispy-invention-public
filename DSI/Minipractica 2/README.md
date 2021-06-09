## DSI Practice 2

## GRAPHICAL INTERFACE OPERATION

- [x] The screen shows a list of cars and, for each one, displays different information fields.
- [x] If the user types something in the FILTER field, only the vehicles whose Make begins with the characters typed by the user will be displayed. So, in the example, if the user types "R" only Renault vehicles will be shown.
- [x] If we click on REDUCE the price of the vehicle will be multiplied by 0.90.
- [x] If we click on SOLD the vehicle will disappear from the list.
- [x] The PVP is the Price x 1,21.
- [x] If the condition of the vehicle is GOOD, the price will be displayed in GREEN background. Otherwise, in RED.

## INSTRUCTIONS TO DEAL WITH THE MICROPRACTICE

- [x] Create a new Angular application (in local repository on your PC):

  - ng new micropractice02

- [x] The data model, this time, we are going to store it in a custom CLASS called Car. This class will be defined in a file called: coche.ts.

 To create it: ng g class car

- [x] Car fields:

  - [x] make, model and picture (can be ="") → string type.
  - [x] model_date and sale_date → date.
  - [x] price → number
  - [x] status → car_status
  - [x] getPVP():number → return price * 1,21
  - [x] enum CarStatus {GOOD, BAD}

- [x] Working with PIPEs:

  - [x] Make will always be presented in CAPITALS.
  - [x] Model will always be in MINUSCRIPLES.
  - [x] Year (only the YEAR of the date of purchase shall be presented).
  - [x] On sale since (present MONTH and YEAR of the date it was put on sale).
  - [x] Price and RRP shall be presented without decimals, and with "," for thousands. Followed by €.

- [x] Working with Angular directives: ngIf, ngClass and ngFor.

  - [x] If car.photo=='' → present text: (no photo!)
  - [x] If car.state==CarState.GOOD → green background (this is done with ngClass).  

## TIP

- To implement FILTERING you can do it in different ways. An easy one, is to create a function that returns a list of IDs (numbers, car indexes in the car list) that meet the condition that their Make field starts with the substring typed by the user in Filter.
- So, the TEMPLATE would look like this: <tr *ngFor='let id of getFiltered();'> and, we would access each element like this: {{cars[id].brand}}, etc....
- In this way, we would have available to process the SOLD and REDUCE buttons, the ID field that is the index of the total cars list (without filtering). This can be very useful to know which one to delete or downgrade.

## MODEL INITIALIZATION

At least two variables must be defined in the model:

public EstadoCoche:any = EstadoCoche; // THIS LINE ONLY SERVES SO WE CAN USE EstadoCoche in the TEMPLATE.

public cars:Array<Car>=[ new Car('renault','scenic',new Date(2007,10,1),new Date(2018,3,1),5000,'car01.jpg',CarStatus.GOOD), new Car('renault','scenic',new Date(2007,10,1),new Date(2018,3,1),5000,'car01. jpg',CarStatus.GOOD), new Car('renault','scenic',new Date(2007,10,1),new Date(2018,3,1),5000,'car01.jpg',CarStatus.GOOD)]

An array of type Car is defined, with values entered "hard code".  

## Deploy in GitHub Pages

No need to create the branch, it creates itself.

Once the repository is created with everything in GitHub.

```terminal
ng add angular-cli-ghpages
ng deploy --base-href=/<repositoryname>/
```
