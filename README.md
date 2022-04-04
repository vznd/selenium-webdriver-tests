# Wikipedia Tests

This repository includes selenium tests examples using [wikipedia.org](https://www.wikipedia.org/).

## How to run tests

To run tests on your local machine, you need to do the following steps:
1) Create the following folder structure on your PC
`/usr/local/bin/chromedriver`
2) Check your local Chrome browser version and download corresponding chromedriver on your local machine.
   You can use an official chrome [web page](https://chromedriver.storage.googleapis.com/index.html).
3) Unzip downloaded archive, e.g. `chromedriver_mac64.zip`
4) Put the unarchived file to the created folder on the 1st step, so you have your driver under the following location:
`/usr/local/bin/chromedriver**`

## Commit message structure

**Commit message template:**
```
<SCOPE>:<small description>
```

**Commit message example:**
```
NEW: add loginTest
```

**Possible scopes:**

| Scope | Description           |
|-------|-----------------------|
| NEW   | Added new test        |
| EXC   | Excluded test         |
| REF   | Made some refactoring |
| DOC   | Documentation changes |


## Branch naming convention

**Branch name structure:**
```
small-description-about-planned-changes
```

**Branch name examples:**
```
add-login-test
refactor-main-page
add-documentation-about-chromedriver
exclude-logout-tests
```

‼️Important‼️ 
Every branch should contain a single commit!
- If you need to apply changes you should use `git commit --amend`
- If you made some wrong changes you should make mixed reset to previous commit, apply changes and make a single commit again.   