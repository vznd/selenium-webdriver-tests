# Welcome to selenium-webdriver-tests contributing guide

Thank you for investing your time in contributing to our project! In this guide you will get an overview of the 
contribution workflow from naming your branch, commit message, creating a PR, reviewing, and merging the PR.

To get an overview of the project, read the [README](https://github.com/vznd/selenium-webdriver-tests/blob/master/README.md).


## Workflow

1) To apply changes to this repository you need to check out from `master` branch  
2) Your branch name should be created according to [branch naming convention](#branch-naming-convention)  
3) Make necessary changes and commit it according to [commit message naming convention](#commit-message-naming-convention)  
4) Create your pull request(PR) according to [pull request conventions](#pull-request-conventions)  


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


## Commit message naming convention

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
| IMP   | Improved code         |


## Pull request conventions

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