---
layout: page
title: Liu Yangming's Project Portfolio Page
---

## Project: IntelliBrary

IntelliBrary is a desktop library management application used for library administrators to manage books. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and uses JavaFX for the GUI.

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
    
* **Enhancements to existing features**:
  * Enhanced the original `add`. Created new Person attributes with teammates and allow `add` to add a Person Model. Set new constraints for person model.(pull requests [#88](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/88))
  * Created new user interface MainWindow and Problem card to accommodate book and report management. (pull requests [#222](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/222) [#224](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/224))
    * Implemented UI component `ProblemReportListCard` and `ProblemReportListPanel`

 **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=richardcom&tabRepo=AY2021S1-CS2103-F09-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

*Other Contributions:
 
* **Project management**:
  * Managed the issue tracking of and project task of Milestone v1.4

* **Documentation**:
  * User Guide:
    * Explained the constraints on `add` command and relating attributes.
    * Explained `random`, and `findMostPopular` commands and the usage for target users.
    * Explained `deleteBy` command and its behaviors in different situations.
    * Explained `findProblemReport`, `deleteProblemReport`, `editProblemReport` commands.
    * Formatted User Guide styling, improved command summary, added visual illustrations.
  * Developer Guide:
    * Explained `add`, `deleteBy`, `findProblemReport`, `deleteProblemReport`, `editProblemReport`, `random`, and `findMostPopular` commands.
    * Created sequence diagrams for `add`, `deleteBy`, `findProblemReport`, `editProblemReport`, `random`, and `findMostPopular` commands, and class diagram for Problem class.
    * Added six user stories and six use cases.
    * Created Non-Functional Requirements.

* **Contributions to the Team-Based Tasks**:
    * Changed the original AB3 `Book` to the new `Person`.
    * Managed branch protection.
    * Worked with teammates to git reset our master branch to resolve Reposense detection errors.
    * Worked with teammates to manage Milestone v1.4.

   
* **Review contributions**:
    pull requests with non-trivial review comments
    [PR301](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/301)  , [PR275](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/275) , [PR245](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/245)
    , [PR244](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/244), [PR242](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/242), [PR241](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/241)
    , [PR237](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/237),  [PR235](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/235) , [PR231](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/231)
    , [PR226](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/226) , [PR221](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/221) , [PR226](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/226)
    , [PR158](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/158), [PR154](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/154), [PR41](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/41)
    , [PR38](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/38), [PR24](https://github.com/AY2021S1-CS2103-F09-3/tp/pull/24).

* **Community contributions**

Helping classmates on forum: [issue221](https://github.com/nus-cs2103-AY2021S1/forum/issues/221), [issue221](https://github.com/nus-cs2103-AY2021S1/forum/issues/221), [issue107](https://github.com/nus-cs2103-AY2021S1/forum/issues/107), [issue15](https://github.com/nus-cs2103-AY2021S1/forum/issues/15)

Helped classmates from other teams identify 15 possible flaws or improvements: [issue195](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/195), [issue194](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/194), [issue191](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/191), , [issue192](https://github.com/AY2021S1-CS2103-F10-2/tp/issues/192), etc.
