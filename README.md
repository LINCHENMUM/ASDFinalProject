## ASD Final Project ReadMe File


In this project we have designed and implemented a framework and use this framework to develop 2 applications: 

## Banking application
### Credit card application


In designing the framework we have used around 5 patterns
###Party Pattern 
We have used it to share common components and to abstract  relationship between person and company to use P2I in other components of the framework.
###Strategy Pattern
When sending notification email for customer , the strategy evaluates the transaction and send notification  based on the specification 
###Template Pattern
We used to share some of the common parts of each strategy for evaluating and sending an email for the customer.
###Mediator Pattern
 to update the UI based on whether the user selects an account or not. Also when there is no data in UI some of components will be updated. 
###Facade 
We used FinCo as a Facade to make controller and other subsystems interactions to pass through it.


The General structure of the FinCo Framework contains three sub-systems
## Account Sub-System
## Customer Sub-System
## Data-access Sub-system

Each of the subsystem uses Model-View-Controller pattern.


The project structure of Bank and CCard application is the same as the Framework structure. We just extend and implement some special classes according to the specific requirement.  

If we could have some time, we would be able to use spring framework or abstract factory pattern for creating objects.  But we had to finish the basic components.




