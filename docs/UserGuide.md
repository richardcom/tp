---
layout: page
title: User Guide
---

IntelliBrary is an **app for managing storage, purchase, borrowing, and reader review of books in NUS library via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).
Targeted at users who can type fast, IntelliBrary can get your library management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `intellibrary.jar` from [here].

3. Copy the file to the folder you want to use as the _home folder_ for your IntelliBrary.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/Linear Algebra i/98765432 e/xxxxxx@example.com ad/xxxxx c/Science c/Math t/20 s/central library 0 science library 0 a/Victor p/pku` : Adds a Book named `Linear Algebra` to the Library.

   * **`delete`**`3` : Deletes the 3rd book shown in the current list.

   * **`clear`** : Deletes all books.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Linear Algebra`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [c/CATEGORY]` can be used as `n/The Great Gatsby c/Novel` or as `n/The Great Gatsby`.

* Items with `…` after them can be used multiple times including zero times.<br>
  e.g. `[c/CATEGORY]…` can be used as (i.e. 0 times), `c/Novel`, `c/Novel c/Classic` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PUBLISHER`, `p/PUBLISHER n/NAME` is also acceptable.

</div>


### Adding a book : `add`

Add a book to the booklist.

Format: `add n/NAME i/ISBN e/EMAIL ad/ADDRESS [c/CATEGORY]...t/TIMES s/STOCKINGS a/AUTHOR p/PUBLISHER`



Examples:
* `add n/Linear Algebra i/98765432 e/xxxxxx@example.com ad/xxxxx c/Science c/Math t/20 s/central library 0 science library 0 a/Victor p/pku`

* `add n/Artificial Intelligence i/9780134610993 e/xxxxxx@example.com ad/xxxxx c/Science t/20 s/central library 2 science library 3 a/Stuart Russell p/PEARSON`



### Deleting a book: `deleteBy`

Delete a book from the booklist.

Format:  
`deleteBy [n/NAME] [i/ISBN] [t/TIMES]` (choose one of the three prefixes in the command)  

Examples:
* `deleteBy n/Linear Algebra`
* `deleteBy i/123456 `

### Check stocking of book in every location: `stock`

Checks the list of locations of where a certain book is stored.
Currently only the science library and central library are available locations.
This means only stocking information regarding the science library and central library are available.

Format: `stock [n/BOOK NAME] [i/ISBN]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**

Both the name and the ISBN of the book are optional argument in the command.

The book name searching follows the all match pattern, where the search name string will be split into keywords according to the white space in between, and the book name will need to contain all of the keywords.

The ISBN name searching follows the some match pattern, where the search number string will be split into keywords according to the white space in between, and the book number will need to contain some of the keywords.

The keyword of book name is case insensitive.

If both the name and the ISBN are used in the command, then the result will be the stocking information of the books that satisfy either of the conditions.

If neither of them are present, then the command will return the stocking information of all the books.

If the value after the prefix is empty, then the command will return the stocking information of all the books.

For example, the command stock n/ and the command stock i/ will return the stocking information of all the books.
</div>

Examples:
* `stock n/A brief history of time i/9780553175219`
* `stock n/A brief history of time`
* `stock i/9780553175219`
* `stock`

### Search for review of book: `searchReview`

Check the list of reviews of certain book.

Format: `searchReview [n/BOOK NAME] [i/ISBN]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**

The usage is similar to the stock command.
</div>

Examples:
* `searchReview n/A brief history of time i/9780553175219`
* `searchReview n/A brief history of time`
* `searchReview i/9780553175219`
* `searchReview`

### Add review: `addReview`

Add a review to a certain book.

Format: `addReview INDEX ra/RATING re/REVIEW CONTENT`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**

The book review will be added according to the index of the book in the current shown book list.

The rating needs to be a string representing an integer from 0 to 5.

The review content should not be empty.
</div>

Examples:
* `addReview 1 ra/5 re/The book is interesing`

### Delete review: `deleteReview`

Delete a review of a certain book.

Format: `deleteReview INDEX rn/REVIEW INDEX`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**

The book review will be deleted from the review list of the book according to the index of the book and the index of the review in the review list of the book.
</div>

Examples:
* `deleteReview 1 rn/1`

### Check usage

Checks usage times of a certain book specified by user. Book is specified by any of the followings:
* one base index in storage.
* book isbn
* book name

Format: 
* `usage [INDEX]`
* `usage i/[ISBN]`
* `usage n/[BOOK_NAME]`

Examples:
* `usage 2`
* `usageBy i/9780141439518`
* `usageBy n/Pride and Prejudice`

### Check history

Checks borrowing times during the whole timeline.

Format: `history`

Examples:
* `history`

### Viewing sample data

Have a look at the sample data for the application when open app for the first time.
*  The sample data will only show up if there is no local data file of IntelliBrary

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Editing a book : `edit`

Edits the information of an existing book in the library.

Format: `edit INDEX [n/NAME] [i/ISBN] [e/EMAIL] [ad/ADDRESS] [t/TIMES] [c/CATEGORY]… [s/STOCKING] [a/ATUHOR] [p/PUBLISHER] [ra/RATING] [re/REVIEW] [rn/REVIEWNUMBER]`

* Edits the book at the specified `INDEX`. The index refers to the index number shown in the displayed book list. The index **must be a positive integer** 1, 2, 3...
* All fileds are optional but at least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing categories, the existing categories of the book will be removed i.e adding of categories is not cumulative.
* You can remove all the book’s categories by typing `c/` without
    specifying any categories after it.

Examples:
* 'edit 2 n/A Brief History of Time e/abhot@gmail.com' Edits the name and contact email address of the 2nd book to be A Brief History of Time and abhot@gmail.com respectively.
* 'edit 3 p/Scribner Publisher t/' Edits the publisher of the 3rd book to be Scribner Publisher and clears all existing tags.

### Check borrowed status `[coming soon]`: `check`

Check the status of a certain book- whether it is available or not.

Format: `status /BOOK_NAME`

Examples:
* `status /Harry Potter`
* `status /Linear Algebra`

### Purge sample data `[coming soon]`: `purge`

Purge all sample data in one go.

Format: `purge`

Examples:
* `purge`

### Report problems: `report`

Report a problem found in library.

Format: `report severity/SEVERITY problem/PROBLEM`

Note that `SEVERITY` is limited to `high`, `medium`, and `low`, case insensitive.

Examples:
* `report severity/high problem/book is broken`

### View problems: `view`

View all reported problems.

Format: `view`

Examples:
* `view`


### Locating reports by keyword: `findpr`

Finds reports whose descriptions contain any of the given keywords.

Format: `findpr KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `chair` will match `Chair`
* The order of the keywords does not matter. e.g. `table chair` will match `chair table`
* Only the description is searched.
* Only full words will be matched e.g. `chair` will not match `chairs`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `table chair` will return `chair light`, `light table`

Examples:
* `findpr chair` returns report containing `chair` and `fix chair`
* `findpr table chair` returns `table`, `chair`

### Deleting a report : `deletepr`

Deletes the specified person from the address book.

Format: `deletepr INDEX`

* Deletes the report at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `findpr chair` followed by `deletepr 1` deletes the 1st report in the results of the `findpr` command.`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous IntelliBrary home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [i/ISBN] [e/EMAIL] [ad/ADDRESS] [t/TIMES] [c/CATEGORY]… [s/STOCKING] [a/ATUHOR] [p/PUBLISHER] [ra/RATING] [re/REVIEW] [rn/REVIEWNUMBER]`<br> e.g.,`edit 3 p/Scribner Publisher t/`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
