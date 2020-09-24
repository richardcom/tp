---
layout: page
title: User Guide
---

IntelliBrary is an **app for managing storage, purchase, borrowing, and reader review of books in NUS library via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). The product is targeted at users who can type fast, IntelliBrary can get your book management tasks done faster than traditional GUI apps.
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### Add books `[coming soon]` : `addBook`

Checks the list of locations of where a certain book is stored.

Format: `addBook /name:NAME /author:AUTHOR /publisher:PUBLISHER /ISBN:ISBN  /cat:CATEGORY /loc:LOCATION STORAGE`


Examples:
* `addBook /name: Numerical linear algebra [electronic resource] : an introduction /author: Holger Wendland /publisher: Cambridge University Press /ISBN: 9781316544938 /cat: Math /loc: Central Library /storage: 5`
* `addBook /name: Artificial Intelligence, A mordern approach /author: Stuart Russell /publisher: PEARSON /ISBN: 978-0-13-461099-3 /cat: Computer Science /loc: Central Library /storage: 6`


### Delete books `[coming soon]`: `deleteBookByIsbn, deleteBookByTimes, deleteBookByName`

Checks the list of locations of where a certain book is stored.

Format:  
`deleteBookByISBN /ISBN`  
`deleteBookByTimes /NUMBER_OF_TIMES_BEEN_BORROWED`  
`deleteBookByName /NAMEOFBOOK`  


Examples:
* `deleteBookByISBN /9781316544938`
* `deleteBookByTimes /0`
* `deleteBookByName /Numerical linear algebra [electronic resource] : an introduction
`

### View Sample Data `[coming soon]`: `view`

Have a look at the sample data for the application when open app for the first time.

Format: `view`

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Editing a book : `edit`

Edits the information of a book in the database.

Format: `edit INDEX /BOOK_NAME /NAME /AUTHOR /PUBLISHER /ISBN /CATEGORY /LOCATION /STORAGE`

* Edits the book at the specified `INDEX`. The index refers to the index number shown in the displayed book list. The index **must be a positive integer** 1, 2, 3, …
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the book will be removed i.e adding of tags is not cumulative.
* You can remove all the book’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  edit /BOOK_NAME: Numerical linear algebra [electronic resource] : an introduction /author: Holger Wendland /publisher: Cambridge University Press /ISBN: 9781316544938 /cat: Math /loc: Central Library /storage: 5

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

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
