# Wikipedia Tests
  
[![CircleCI](https://circleci.com/bb/den44/wikipedia-tests.svg?style=shield&circle-token=beec6688d1137f803b984f0bd3564ba6caaeeb9b)](https://app.circleci.com/pipelines/bitbucket/den44/wikipedia-tests?branch=master&filter=all)

This repository includes selenium tests examples using [wikipedia.org](https://www.wikipedia.org/).


## How to run tests

To run tests on your local machine, you need to do the following steps:  
1) Create the following folder structure on your PC `/usr/local/bin/chromedriver`  
2) Check your local Chrome browser version and download corresponding chromedriver on your local machine. You can use an official Chrome [web page](https://chromedriver.storage.googleapis.com/index.html).  
3) Unzip downloaded archive, e.g. `chromedriver_mac64.zip`  
4) Put the unarchived file to the created folder on the 1st step, so you have your driver under the following location: `/usr/local/bin/chromedriver`  
5) Clone this repository  
6) Run `mvn test`  




## Conventions

This section includes all conventions that should be strongly followed in this repository. All exceptional cases should be discussed individually.


### Branch naming convention

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


### Commit naming convention

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


### Pull request conventions

1) All changes to a `master` branch should be applied through a Pull Request(PR)  
2) Each PR(and/or source branch) should contain only a single commit  
3) PR title should equal to a commit message  
4) If your PR is NOT ready to be reviewed, mark its title as draft, e.g. `[DRAFT] NEW: added xxx test`  
5) All the required details about PR, should be clearly pointed out in the PR Description  
6) If you need to apply extra changes:  
- Make necessary changes locally  
- Commit it using `git commit --amend`  
- Make a force push to a source branch `git push -f origin <source-branch>`  
**OR alternatively:**  
- Make a mixed reset to previous commit `git reset <previous-hash-commit>`  
- Make necessary changes  
- Commit it as a regular commit `git add .; git commit -m "<your-commit-message>"`  
- Make a force push to a source branch `git push -f orig in <source-branch>`  
7) Once PR is approved, a `<source-branch>` should be merged to a `master` branch with a fast-forward option (`git merge --ff-only`).  