---
layout: page
title: Liu Yangming's Project Portfolio Page
---
## Project: IntelliBrary

IntelliBrary is a desktop library management application used for library administrators to manage books. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and uses JavaFX for the GUI. Listed below are my contributions to this project.

* **New Feature** Created new Storage and UI for problem reports; Implemented Search (`findProblemReport`), edit (`editProblemReport`), and delete (`deleteProblemReport`) problem reports.
    * What it does: allows the librarian to search for reports that contain keywords, edit the reports, and delete reports.
    * Justification: This feature improves the product significantly because it librarians are now able to manage problem reports besides books management. They can also gather relevant problem reports for more efficient processing.
    * Highlights: The implementation affects the structure of storage and UI of the application. In-depth analysis of the storage structure and UI structure is needed during implementation. 
    
* **New Feature** Command 1. Find the most popular book `findMostPopular`; Command 2. randomized selection of books `random`.
    * What it does: 1. allows the librarian to find the most popular book of each category; 2. allows librarians to have randomized selection of books of each categories.
    * Justification: This feature improves the product significantly because it enables librarians to analyze popularity of books of various categories, and conveniently conduct valid random sampling data analysis.

* **New Feature** Delete book efficiently by book name or ISBN; Batch deletion of unpopular books which are rarely borrowed. `DeleteBy`
    * What it does: allows the librarian directly delete a book by name or ISBN. Librarians can also delete all unpopular books which are rarely borrowed.
    * Justification: This feature improves the product significantly because it makes it easier for librarians to efficiently delete books without the need to find it first. Librarians
    can also efficiently batch manage and clean up unpopular books.
* **Tests**  Created tests for `add`, `deleteBy`, `findProblemReport`, `deleteProblemReport`, `editProblemReport`, `random`, and `findMostPopular` commands, which improves the test coverage of our application.
* **Enhancements to existing features**:
  * Enhanced the original `add`. Created new Model `Author` and allow `add` to add a Book Model. Set new constraints for book's attributes.(pull requests [#88](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/88))
  * Created new user interface MainWindow and Problem card to accommodate book and report management. (pull requests [#222](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/222) [#224](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/224))
    * Implemented UI component `ProblemReportListCard` and `ProblemReportListPanel`

 **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=richardcom&tabRepo=AY2021S1-CS2103-F09-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)
 
* **Project management**:
  * Managed the issue tracking of and project task of Milestone v1.4

* **Documentation**:
  * User Guide:
    * Explained the constraints on `add` command and relating attributes.
    * Explained `random`, and `findMostPopular` commands and the usage for target users.
    * Explained `deleteBy` command and its behaviors in different situations.
    * Explained `findProblemReport`, `deleteProblemReport`, `editProblemReport` commands.
    * Updated command summary, added visual illustrations, and formatted User Guide styling.
  * Developer Guide:
    * Upadated `Architecture` and `Logic` Component of DG.
    * Explained `add`, `deleteBy`, `findProblemReport`, `deleteProblemReport`, `editProblemReport`, `random`, and `findMostPopular` commands.
    * Created sequence diagrams for `add`, `deleteBy`, `findProblemReport`, `editProblemReport`, `random`, and `findMostPopular` commands, and class diagram for Problem class.
    * Added six user stories and six use cases.
    * Created Non-Functional Requirements.

* **Contributions to the Team-Based Tasks**:
    * Morph the original AB3 from `Person` to the new `Book`.
    * Managed branch protection.
    * Worked with teammates to git reset our master branch to resolve Reposense detection errors.
    * Worked with teammates to manage Milestone v1.4.
    * Changed footer of the application `intellibrary`

   
* **Review contributions**:
    pull requests review comments
    [PR301](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/301)  , [PR275](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/275) , [PR245](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/245)
    , [PR244](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/244), [PR242](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/242), [PR241](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/241)
    , [PR237](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/237),  [PR235](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/235) , [PR231](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/231)
    , [PR226](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/226) , [PR221](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/221) , [PR226](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/226)
    , [PR158](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/158),  [PR41](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/41).

* **Community contributions**

Helping classmates on forum: [issue221](https://github.com/nus-cs2103-AY2021S1/forum/issues/221), [issue221](https://github.com/nus-cs2103-AY2021S1/forum/issues/221), [issue107](https://github.com/nus-cs2103-AY2021S1/forum/issues/107), [issue15](https://github.com/nus-cs2103-AY2021S1/forum/issues/15)

Helped other teams identify flaws: [issue195](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/195), [issue194](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/194), [issue191](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/191), , [issue192](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/192), etc.





* **[Optional] Contributions to the User Guide**



* **User Guide**

#### Adding a book : `add`

Adds a book to the book list.

Duplicate book will be rejected.

Format: `add n/NAME i/ISBN e/EMAIL l/LANGUAGE [c/CATEGORY]...t/TIMES s/[STOCKINGS] a/AUTHOR p/PUBLISHER`

* ```n/``` is followed by the book name, it is case sensitive.
* ```i/``` is followed by the ISBN of the book, which is restricted to digits.
* ```e``` is followed by the email of the book dealer, which shall follow the valid format of email address.
* ```l/``` is followed by the language of the book. We decide to accept any string input as language because there are hundreds of languages in the world, and it would be inefficient to store all of them.
* ```c/``` is the category of the book and is optional. For restrictions on categories, please refer to the detailed explanation in the later category part.
* ```t/``` is followed by the number of times that the book is borrowed, it is restricted to a non-negative integer.
* ```s/``` is followed by the stocking information, stockings at 0 to 3 specified libraries can be added(please refer to the stocking part for more details).
 And the prefix tag ```s/``` is compulsory when adding a book.
* ```a/``` is followed by the author of the book, it should only contain alphanumeric characters and spaces, and it should not be blank.
* ```p/``` is followed by the publisher of the book, it should only contain alphanumeric characters and spaces, and it should not be blank.
* Duplicate book is judged by the ISBN, as ISBN is the unique identification for books of different versions, editions, and variations.
Thus, we store books seperately as long as they have different ISBN, even if they share the same name.

Visual View after entering the first example command:

![Add View](images/add_command.png)

Examples:
* `add n/Linear Algebra i/98765432 e/seller@example.com l/English c/Science c/Math t/20 s/centralLb 30 scienceLb 15 HSSMLb 10 a/Victor p/pku`

* `add n/Artificial Intelligence i/9780134610993 e/Pearson@example.com l/English c/Science t/20 s/centralLb 2 scienceLb 3 HSSMLb 4 a/Stuart Russell p/PEARSON`



#### Deleting books(s) from the library `delete` and `deleteby`

Deletes the specified book(s) from the library.

##### Deletes a book by its index in the current list `delete`

Format: `delete INDEX`

* Deletes the book at the specified `INDEX`.
* The index refers to the index number shown in the displayed book list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete 2` deletes the 2nd book in the library.
* `find novel` followed by `delete 1` deletes the 1st book in the results of the `find` command.

##### Deleting a book by other attributes: `deleteBy`

Delete a book from the library.

Format:  
`deleteBy [n/NAME] [i/ISBN] [t/TIMES]` (choose one of the three prefixes in the command)  

* one of the three prefixes must be selected to delete a list of books that match the command.
* The command allows batch deletion of a list of books. Especially in ```deleteBy t/TIMES```, 
for all the books which has times of been borrowed less or equal to the user input will be deleted.
* Notice: if the user enters multiple prefixes at a time, only the last prefix input will be considered.

Examples:
* `deleteBy n/Linear Algebra`
* `deleteBy i/123456 `



#### Random Selection of books `random`

Randomly select a book of a specific category from the library.

Introduction: the `random` command is implemented for librarians for two situations:
1. Random sampling. 

One of the librarians' job is to conduct statistical analysis of the books' data
in the library. For example, a librarian needs to gather data of a certain category of books
(average rating, times borrowed, etc). However, as libraries normally contain tens thousands or millions 
of books, random sampling technique is widely adopted. Thus, the `random` command allows
librarians to randomly select a book from a certain category. This greatly boosts the efficiency and ensures
randomness of random sampling.

2. Random recommendation: 

For a certain category of books, some books may remain in the library without gathering much
attention, which causes waste for the library. Thus, the `random` command allows the 
librarian to pick a random book of a specific 
category and gives every book the same probability to be promoted to public.


Format: `random CATEGORY`

* The category name is matched using case-sensitive approach. For example, `Classics` is different
from `classics`
* If there are no books matching the user input, `0 books listed!` will pop up.
* If multiple categories are entered and separated by a space, only the last category will be processed by the command.


Examples:
* `random Classics`
* `random Science`


#### Find the most popular book of a specific category `findMostPopular`

Find and select the most popular book of a specific category from the library.

Format: `findMostPopular CATEGORY`

* The category name is matched using case-sensitive approach. For example, `Classics` is different
from `classics`
* If there are no books matching the user input, `0 books listed!` will pop up.
* If multiple categories are entered and separated by a space, only the last category will be processed by the command.

Examples:
* `findMostPopular Classics`
* `findMostPopular Science`




#### Locating reports by keyword: `findProblemReport`

Finds reports whose descriptions contain any of the given keywords.

Format: `findProblemReport KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `chair` will match `Chair`
* The order of the keywords does not matter. e.g. `table chair` will match `chair table`
* Only the description of a problem report is searched.
* Only full words will be matched e.g. `chair` will not match `chairs`
* Report descriptions matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `table chair` will return `chair light`, `light table`

Visual View of finding report reports that is related to `level 1`:

![Find Report View](images/findReport.png)

Examples:
* `findProblemReport chair` returns report containing `chair` and `fix chair`
* `findProblemReport table chair` returns `table`, `chair`



#### Deleting a report : `deleteProblemReport`

Deletes the specified problem report from library management system.

Format: `deleteProblemReport INDEX`

* Deletes the report at the specified `INDEX`.
* The index refers to the index number shown in the displayed problem report list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `findProblemReport chair` followed by `deleteProblemReport 1` deletes the 1st report in the results of the `findProblemReport` command.`
* `findProblemReport table` followed by `deleteProblemReport 2` deletes the 2nd report in the results of the `findProblemReport` command.`

#### Editing a problem report : `editProblemReport`

Edits the information of an existing problem report in the library.

Format: `editProblemReport INDEX [s/SEVERITY] [d/DESCRIPTION]`

* Edits the report at the specified `INDEX`. The index refers to the index number shown in the displayed report list. The index **must be a positive integer** 1, 2, 3...
* All fields are optional but at least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
* `editProblemReport 2 s/high d/light at the first floor is broken` Edits the severity and description of the 2nd report in the current report list.
* `editProblemReport 3 s/low` Edits the severity of the 3rd report in the current report list.


And I also updated command summary with my teammates.



* **Developer Guide**

Update:

### Architecture

<img src="images/ArchitectureDiagram.png" width="450" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/AY2021S1-CS2103-F09-3/tp/tree/master/docs/diagrams) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`](https://github.com/AY2021S1-CS2103-F09-3/tp/blob/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/AY2021S1-CS2103-F09-3/tp/blob/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

The sections below give more details of each component.




### Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/language/logic/Logic.java)

1. `Logic` uses the `LibraryParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a book).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>



Created:




### \[Enhanced\] Add Book feature

####  Implementation

The current implementation of the AddCommand is supported by `AddCommand.java`, `AddCommandParser.java`.

The relevant methods are:

*`AddCommandParser#parse(String args)` --- Parses the book's detailed information.
*`AddCommand#execute(Model model)` --- Checks for duplication and adds the book to the library.

Given below is an example usage scenario and how the AddCommand mechanism behaves at each step.

Step 1. User input: `add n/Linear Algebra i/98765432 e/seller@example.com l/English c/Science c/Math t/20 s/centralLb 30 scienceLb 15 HSSMLb 10 a/Victor p/pku`

Step 2. Logic Manager would parse the input `add n/Linear Algebra i/98765432 e/seller@example.com l/English c/Science c/Math t/20 s/centralLb 30 scienceLb 15 HSSMLb 10 a/Victor p/pku`, and determines that it is an Add command.

Step 3. AddCommandParser would then parse the book attributes and call the Add Command.

Step 4. Execution of Add would take place and the result will be updated in the filtered book list in Model.

The following sequence diagram summarizes what happens when a user executes a new command:

![AddCommandSequenceDiagram](images/AddCommandSimplifiedSequenceDiagram.png)

#### Design consideration:

##### Aspect: How add book command executes

* **Alternative 1:** Individual separated commands of Add author, Add publisher, Add categories, etc.
  * Pros: Easier to implement without the need to modify the original Add command.
  * Cons: Multiple commands are needed during input and it is inconvenient for users.

### \[New\] DeleteBy feature

####  Implementation

The implementation of the DeleteBy command is supported by `DeleteByCommand.java` and `DeleteByCommandParser.java` 

The relevant methods are:

*`DeleteByCommandParser#parse(String args)` --- Parses the user input: book name, ISBN, or number of borrowed times.
*`DeleteByCommand#execute(Model model)` --- Deletes the book from the library.

Given below is an example usage scenario and how the DeleteBy mechanism behaves at each step.

Step 1. User input an input: `deleteBy n/Linear Algebra`

Step 2. Logic Manager would parse the input `deleteBy n/Linear Algebra`, and determines that it is a deleteBy command.

Step 3. DeleteByCommandParser would then parse the book name and call the deleteBy Command.

Step 4. Execution of delete would take place and the result will be updated in the filtered list in Model.

The following sequence diagram summarizes what happens when a user executes a new command:

![DeleteByCommandDiagram](images/DeleteBySequenceDiagram.png)

#### Design consideration:

##### Aspect: How deleteBy executes

* **Alternative 1 :** Adopts the delete function of the original project
  * Pros: Easy to implement.
  * Cons: Not convenient for expert users and fast input, does not allow deleting multiple books at a time.

* **Alternative 2:** Individual command of DeleteByName, DeleteByISBN, DeleteByTimes
  itself.
  * Pros: Easier to implement without the need to parse different input types.
  * Cons: A large portion of duplicated code for multiple commands.





### \[New\] Find the most popular book feature

####  Implementation

The implementation of the FindMostPopular command is supported by `FindMostPopularCommand.java` and `FindMostPopularCommandParser.java` 

The relevant methods are:

*`FindMostPopularCommandParser#parse(String args)` --- Parses the input into book category.
*`FindMostPopularCommand#execute(Model model)` --- Finds the most popular book of the specified category and updates the filtered book list.


Given below is an example usage scenario and how the FindMostPopular mechanism behaves at each step.

Step 1. User input an input: `findMostPopular science`

Step 2. Logic Manager would parse the input `findMostPopular science`, and determines that it is a findMostPopular command.

Step 3. FindMostPopularCommandParser would then parse the category type and call the findMostPopular Command.

Step 4. Execution of findMostPopular would take place. The most popular book(borrowed the most number of times) will be found
 and the result will be updated in the filtered list in Model.

The following sequence diagram summarizes what happens when a user executes a new command:

![findMostPopularSequenceDiagram](images/findMostPopularSequenceDiagram.png)

#### Design consideration:

##### Aspect: How find Most Popular executes

* **Alternative 1 :** Stores the most popular book as an attribute of each category
  * Pros: Easy to retrieve the most popular book.
  * Cons: Needs auto-refresh when the borrowed times of different books change.

* **Alternative 2:** Return the most popular book found directly to the UI
  * Pros: Easier to implement.
  * Cons: Does not follow the abstraction layers of UI.

### \[New\] Randomized selection of book feature

####  Implementation

The implementation of the Random command is supported by `RandomCommand.java` and `RandomCommandParser.java` 

The relevant methods are:

*`RandomCommandParser#parse(String args)` --- Parses the input into book category.
*`RandomCommand#execute(Model model)` --- Randomly selects a book of the specified category and updates the filtered book list.


Given below is an example usage scenario and how the Random mechanism behaves at each step.

Step 1. User input an input: `random Classics`

Step 2. Logic Manager would parse the input `random Classics`, and determines that it is a Random command.

Step 3. RandomCommandParser would then parse string input and call the Random Command.

Step 4. Execution of Random would take place. A randomly selected book of the specified category will be found
 and the result will be updated in the filtered list in Model.

The following sequence diagram summarizes what happens when a user executes a new command:

![randomCommandSequenceDiagram](images/randomCommandSequenceDiagram.png)

#### Design consideration:

##### Aspect: How randomly select a book executes

* **Alternative 1 :** Randomly select a book from the current filtered list.
  * Pros: Easy to implement with the current filteredBookList.
  * Cons: Tedious and inconvenient when users want to randomly select a book of a certain category.






### \[New\] Edit Problem Report feature

####  Implementation

The implementation of the Edit Problem Report command is supported by `EditProblemCommand.java` and `EditProblemCommandParser.java` 

The relevant methods are:

*`EditProblemCommandParser#parse(String args)` --- Parses the user input arguments.
*`EditProblemCommand#execute(Model model)` --- Edits the book with the user input and updates the book list of the library.

Below is the diagram illustrating the Problem Report Model. The EditProblemCommand allows for edit of either one attribute
or both attributes at the same time.

![ModelClassReportDiagram](images/ModelClassReportDiagram.png)

Given below is an example usage scenario and how the edit problem report mechanism behaves at each step.

Step 1. User input an input: `editProblemReport 2 s/high d/light at the first floor is broken`

Step 2. Logic Manager would parse the input `editProblemReport 2 s/high d/light at the first floor is broken`, and determines that it is a EditProblemCommand command.

Step 3. EditProblemCommandParser would then parse string input and call the EditProblemCommand.

Step 4. Execution of EditProblemCommand would take place. The report at the specified index will be edited
and updated according to user input.

The following sequence diagram summarizes what happens when a user executes a new command:

![EditProblemReportSequenceDiagram](images/EditProblemReportSequenceDiagram.png)

### \[New\] Find Problem Report feature

####  Implementation

The implementation of the Find Problem Report command is supported by `FindProblemCommand.java` and `FindProblemCommandParser.java` 

The relevant methods are:

*`FindProblemCommandParser#parse(String args)` --- Parses the user input arguments.
*`FindProblemCommand#execute(Model model)` --- Finds the problem report which has the description that matches the user input.


Given below is an example usage scenario and how the find problem report mechanism behaves at each step.

Step 1. User input an input: `findProblemReport chair`

Step 2. Logic Manager would parse the input `findProblemReport chair`, and determines that it is a FindProblemCommand command.

Step 3. FindProblemCommandParser would then parse string input and call the FindProblemCommand.

Step 4. Execution of FindProblemCommand would take place. The problems reports which has the description containing the keywords
will be displayed.

The following sequence diagram summarizes what happens when a user executes a new command:

![EditProblemReportSequenceDiagram](images/FindProblemReportSequenceDiagram.png)


### \[New\] Delete Problem Report feature

####  Implementation

The implementation of the DeleteProblem command is supported by `DeleteProblemCommand.java` and `DeleteProblemCommandParser.java` 

The relevant methods are:

*`DeleteProblemCommandParser#parse(String args)` --- Parses the user input index.
*`DeleteProblemCommand#execute(Model model)` --- Deletes the report of the input index from the library.

Given below is an example usage scenario and how the delete problem report mechanism behaves at each step.

Step 1. User input an input: `deleteProblemReport 2`

Step 2. Logic Manager would parse the input `deleteProblemReport 2`, and determines that it is a delete problem command.

Step 3. DeleteProblemCommandParser would parse the index of the report to be deleted.

Step 4. Execution of DeleteProblem would take place and the result will be updated in the filtered list in Model.




Use cases:


**Use case: UC01 - Add a book**

**MSS**
  1. User request to add a new book into the library.

  2. IntelliBrary adds the book to the library and shows a successfull message to the user.
  
     Use case ends.
  
**Extensions**

* 1a. The book to be added is already found in the library.
    
    * 1a1. IntelliBrary shows an error message that the book is already stored in the library.
    
      Use case ends.

* 1b. Some information about the book is not entered in the command.

    * 1b1. IntelliBrary shows an error message that the information about the book is incomplete.

      Use case ends.
      
* 1c. The data type of some of the book information is incorrect.
    
    * 1c1. IntelliBrary shows an error message that data type of some of the book information is incorrect.
    
      Use case ends.
    
    
    
    
  
**Use case: UC14 - Delete a problem report**

**MSS**
  1. User requests to delete a problem report by index.
  2. IntelliBrary deletes the problem report and shows a successfull message to the user.

  Use case ends. 
  
**Extensions**

* 1a. The index given by the user is invalid.

    * 1a1. IntelliBrary shows an error message that index given by the user is invalid.

      Use case ends.
    
    
**Use case: UC15 - Find a problem report by description**

**MSS**
  1. User requests to find reports that the descriptions matches certain keywords.
  2. IntelliBrary finds reports which descriptions matches the keywords.

  Use case ends. 
  
**Extensions**

* 1a. No problem reports that the description matches the keyword is found.

    * 1a1. IntelLiBrary shows a message that no matching reports are found.

      Use case ends.
      
      
**Use case: UC16 - Find Most popular book of a category**

**MSS**
  1. User requests to find the most popular book of a category.
  2. IntelliBrary finds the most popular book of a category.
  
     Use case ends.
  
**Extensions**

* 1a. The input category name is invalid
    
    * 1a1. IntelliBrary shows a message indicating the command is invalid.
    
      Use case ends.
    
* 1b. There are currently no books of the category.
    
    * 1b1. IntelliBrary shows a message saying that zero books are listed.
    
      Use case ends.
    
**Use case: UC17 - Randomized selection of a book of a category**

**MSS**
  1. User requests to randomly select a book of a specified category.
  2. IntelliBrary randomly select a book of a specified category.
  
     Use case ends.
  
**Extensions**

* 1a. The input category name is invalid
    
    * 1a1. IntelliBrary shows a message indicating the command is invalid.
    
      Use case ends.
      
* 1b. There are currently no books of the category.
    
    * 1b1. IntelliBrary shows a message saying that zero books are listed.
    
      Use case ends.      
   
   
   
   
   
### Non-Functional Requirements

1.  Technical requirements: should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Data requirements: should be able to hold up to 1000 books without a noticeable sluggishness in performance for typical usage.
3.  Performance requirements: for core functions, the system should respond within two seconds.
4.  Quality requirements: a user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
5.  Process requirements: the project is expected to adhere to the course schedule and delivers weekly tasks on time.
6.  Domain rules: the number of books at each library cannot be less than three.
