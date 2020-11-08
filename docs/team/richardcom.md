---
layout: page
title: Liu Yangming's Project Portfolio Page
---

## Project: IntelliBrary

IntelliBrary is a desktop library management application used for library administrators to manage books. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Listed below are my contributions to this project.

* **New Feature** Created Storage and UI for problem reports. Implemented Search(`findProblemReport`), edit(`editProblemReport`), and delete(`deleteProblemReport`) problem reports.
    * What it does: allows the librarian to search for reports that contain keywords, edit the reports, and delete reports.
    * Justification: This feature improves the product significantly because it librarians are now able to manage problem reports besides books management. They can also gather relevant problem reports for more efficient processing.
    * Highlights: The implementation affects the structure of storage and UI of the application. I need to have in-depth analysis of the storage structure and UI structure. 
    
* **New Feature** Command 1. Find the most popular book`findMostPopular` and Command 2. randomized selection of books `random`.
    * What it does: 1. allows the librarian to find the most popular book of each category; 2. allows librarians to have randomized selection of books of each categories.
    * Justification: This feature improves the product significantly because it enables librarians to analyze popularity of books of various categories, and conveniently conduct valid random sampling data analysis.

* **New Feature** Delete book efficiently by book name or ISBN. Batch deletion of unpopular books which are rarely borrowed. `DeleteBy`
    * What it does: allows the librarian directly delete a book by name or ISBN. Librarians can also delete all unpopular books which are rarely borrowed.
    * Justification: This feature improves the product significantly because it makes it easier for librarians to efficiently delete books without the need to find it first. Librarians
    can also efficiently batch manage and clean up unpopular books.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=richardcom&tabRepo=AY2021S1-CS2103-F09-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

* **Enhancements to existing features**:
  * Create new user interface book card to accommodate different command: `Review` (pull requests [#80](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/80) [#126](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/126))
    * Added the user interface component `LibraryBookDetailStockingCard`
    * Added the user interface component `LibraryBookDetailReviewCard` and `BookReviewCard` which show the review of a book.
  * Add book cover (pull requests [#102](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/102))
    * Added the `BookCoverManager` and the and selects the book cover for a book based on the category of the book.
    * Added the user interface component `BookCardWithCover` which shows the information of a book with the book cover.
  * Wrote additional tests for existing features (pull requests [#255](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/255))

* **Project management**:
  * Managed the issue tracking and project task of Milestone mid v1.3 and opened Milestone v1.4

* **Documentation**:
  * User Guide:
    * Added explanation about the association between the `BookCover` and the category of the book.
    * Added explanation about the format of `Stocking` in the `add` command.
    * Added explanation about the purpose of the `Review` functionality and its usage for the user of the application.
    * Added documentation about the usage of `stock` command
    * Added documentation about the usage of `searchReview`, `addReview`, `deleteReview`, and `editReview` command
  * Developer Guide:
    * Specified the target user profile regarding librarian (pull requests [#24](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/24))
    * Added implementation details about stocking (pull requests [#111](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/111)).
    * Added the Class Diagram to explain the association between `Book` and `Stocking`
    * Added Sequence Diagram for parsing `Stocking` model in `add` command 
    * Added Sequence diagram for parsing and execution of `stock` command
    * Specified the use cases UC04, UC05, UC06, UC07, and UC08.

* **Contributions to the Team-Based Tasks**:
    * Wrote the target user profile and value proposition in the Developer Guide
    * Changed the icon of the application.
    * Helped to wrote the command summary in User Guide
    * Opened Milestone v1.4 and managed the team project task in Milestone mid v1.3
    * Maintained the issue tracker and managed the team project task for Milestone mid v1.3
    * Provided technical suggestion for calculating the total number of times when a certain group of books is borrowed in the History command using `getFilteredBookList`
    * Helped to solve technical issues of RepoSense contribution detection in week 12, and provided suggestion to use `git reset` to set the state of upstream master branch.
    
* **Review contributions**:
    pull requests with non-trivial review comments
    [PR1](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/21) 
    | [PR2](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/64) 
    | [PR3](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/73)
    | [PR4](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/78)
    | [PR5](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/90)
    | [PR6](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/91)
    | [PR7](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/134)
    | [PR8](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/268)

* **Community contributions**

[Response of question in the forum](https://github.com/nus-cs2103-AY2021S1/forum/issues/370)

Reported the documentation, functionality, and feature problems for the project from CS2103-F10-1

[issue1](https://github.com/AY2021S1-CS2103-F10-1/tp/issues/180)
| [issue2](https://github.com/AY2021S1-CS2103-F10-1/tp/issues/168)
| [issue3](https://github.com/AY2021S1-CS2103-F10-1/tp/issues/170)

* **Optional contributions to the User Guide**

Each section below is an extract of the original section in the User Guide. Please see the User Guide for the full content in the corresponding section.

##### Regarding categories and book cover
The list of relevant categories are given below in ascending order with respect to the priority of the category. The book cover of a book depends on the categories of the book according to the category priority.

`General` `Novels` `History` `Science` `AncientHistory` `ModernHistory` `AncientWar` `ModernWar` `Math` `Chemistry` `Physics`

##### Check stocking of book in every location: `stock`

Checks the list of locations of where a certain book is stored. Currently only the science library, central library, and HSSM library are available locations.

Format: `stock [n/BOOK NAME] [i/ISBN]`

##### Additional notes about review

The purpose of the review functionality is for librarian to collect and record review and feedback from readers about a certain book, and estimates the general rating and popularity of the book among readers.

##### Search for review of book: `searchReview`

Check the list of reviews of certain book.

Format: `searchReview [n/BOOK NAME] [i/ISBN]`

##### Add review: `addReview`

Add a review to a certain book. 

Format: `addReview INDEX ra/RATING re/REVIEW_CONTENT`

##### Delete review: `deleteReview`

Delete a review of a certain book.

Format: `deleteReview INDEX rn/REVIEW_INDEX`

##### Edit review: `editReview`

If neither rating or review content is present, then an exception message will be shown. If the edited review is the same as the original review, then a corresponding exception message will be shown. 

* **Optional contributions to the Developer Guide**

The relationship between the book and the stocking and other components

![The relationship between the book and the stocking and other components](../images/ModelClassBookStockingDiagram.png)

The creation of the stocking

![The creation of the stocking](../images/EditStockingParserSequenceDiagram.png)

The creation of the stock command

![The creation of the stock command](../images/StockCommandParserSequenceDiagram.png)

The class diagram of the review

![The class diagram for review](../images/ModelClassBookReviewDiagram.png)

The creation of the add review command

![The creation of the add review command](../images/AddReviewParserSequenceDiagram.png)

