## Git

https://www.notion.so/xxiaomm/Git-Github-fbf9a4779efe449b89e6e9d0990db992

Git is a free and **open source distributed version control system** designed to
handle everything from small to very large projects with speed and efficiency.

### Benifits:

- Keep **track** of file changes
- Provides **metadata** for each file change (date, description)
- Allows us to **switch** between different file versions
- Provides an easy way to **rollback** file changes

### Centralized VS. Distrubuted

|         | Centralized                                                  | Distrubuted                                                  |
| ------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Storage | Store all the files in a **single** server                   | Each machine holds a **copy** of the code repository         |
|         | Multiple users cannot work on the same file at the same moment (order matters) | Use remote code repository for file exchange (act as central server) |
|         | All users must connect to the server before submitting or downloading files (network required) |                                                              |
| Example | Concurrent Versions System (CVS) was one of the very first centralized version control systems. | Example: Git is a distributed version control system         |
| Pros    | Transparent Operation, simple                                | flexible, Not single point of failure                        |
| Cons    | Single Point of Failure, if central server fails, all lose access | Need more efforts to manage change history and authentication |
|         |                                                              |                                                              |

### Git commands

#### Basic commands

- `git init` - initialize a new repo
- `git clone <url> `: clone a repo from remote
- `git clone -b <branch-name> <url>`: clone a **specific** remote **branch**
- `git status`
- `git add . ` or `git add <file-name>` 
- `git commit (<file-name>) -m "commit message"`
- `git rm --cached .`  or `git rm --cached <filename>` : remove from staging, git 不再track当前file/当前目录及子目录所有文件，但local仍然保留这些

#### Branching and Merging

- `git branch`: list all **local** branches
- `git branch -r`: list all **remote** branches
- `git branch -a`: list all branches
- `git branch <branch_name>`: create a new branch
- `git checkout (-b) <branch_name>`: switch to the branch (if -b, create and switch)
- `git branch -d <branch-name>`: delete branch
- `git branch -M main`: -M强制重命名当前分支，适合用于更新默认分支名称或其他重命名操作。通过 `-M` 选项，命令会强制重命名，忽略目标分支是否已经存在。
- `git branch <new-branch-name> <existing-branch-name>`: rename

#### Remote

- `git remote add <name(origin / main)> <repo-url>` : link local to remote repo

- **`git rebase <remote-branch>`**: 将local 的commit重新放到远程branch的最新commit上，形成一个线性的提交历史，不会创建合并提交，使历史记录更简洁。
  - `git rebase --continue`: continue after solving conflicts
  - `git rebase --abort`: stop 
- `git fetch <remote origin>`:  fetch remote changes to local but **without merging** 
- `git pull <remote> <branch>`: **Fetches and merges** changes from the remote repo into the local branch. == `git fetch + git merge`
- `git push <remote> <branch>`: push local branch changes to the remote repository.
- `git merge <branch-name>` : merge branch into current
- `git merge --abort`: cancel merge, return to status before merging

#### Useful commands

- `git stash`: store current un-commit changes into a stack, return to previous commit
- `git stash apply stash@{n}` : Restore recent(specific) stash to working directory
- `git stash pop`: restore recent stash and delete stash
- `git log`: show commit history
- `git diff`: show the changes between the working directory and the index (staging area).
- `git reset --soft HEAD^` 放弃commit的内容
- `git reset --hard HEAD^` 放弃commit和add的内容
- `git config --global user.name` ,`git config --global user.email`: show name/email of current user



```bash
# creat directory for project
mkdir project
# go to the directory
cd project
# init a new git repo
git init 

# clone remote repo url
git clone repository_url 

# create a new branch
git checkout branch_name
# or create a new branch and go to that new branch
git checkout -b branch_name

# go to main branch
git checkout main
# pull newest update from remote
git pull
# merge branch_test to main branch
git merge branch_test
# push local change to remote
git push

# store local changes in branch named branch_learn_stash
git stash
# switch to another branch
git checkout another_branch_name
# switch back to branch_learn_stash
git checkout branch_learn_stash
# pop stored changes / stash
git stash pop
```



#### Using Git Stash in IntelliJ
- Menu bar `Git` -> `VCS Operations Popup` -> `Stash Changes`
- Add `Message` -> `Create Stash`
- Switch to other branch
- Switch back to branch `branch_learn_stash`
- Menu bar `Git` -> `VCS Operations Popup` -> `Unstash Changes` -> `Apply Stash`


### How do you understand PR is based on Branch?
- PR, pull request is a **request to merge** your local branch changes to target branch.
- The branch that your PR selected, contains all local changes and commits, we could view all detailed changes of 
  each commit.

### Git Actions

- GitHub Actions is a **continuous integration and continuous delivery (CI/CD)**
  platform that allows developers automate their build, test, and deployment **pipeline**.
- Developers can create **workflows** that build and test every pull request to their
  repository, or deploy merged pull requests to production

## Maven

https://www.youtube.com/watch?v=KNGQ9JBQWhQ

https://www.tutorialspoint.com/maven/index.htm

https://www.javatpoint.com/maven-tutorial

### What is maven role?
Maven is a powerful build automation tool which could simplify the process of building project, managing dependency and
configuration.

### Maven is used for:
- **Simplified Build Process:** includes compiling code, running tests, packaging code into JAR files, deploying 
  application.
- **Dependency Management:** Use a `pom.xml` or `application.properties` file to manage dependencies, allow to 
  download libraries and dependencies automatically. This helps ensure that the correct versions of dependencies are used and reduces conflicts.
- **Continuous Integration:** Maven is used in continuous integration (CI) environments to automate the build, test and 
  deployment process. It integrates well with CI tools like Jenkins, Bamboo, and Travis CI.
- **Documentation:** Maven can generate project documentation based on the information in the POM file, including project reports, dependencies, and developer information.


### What is the lifecycle of maven? could you tell me the details ?

1. **Validate**: Validates the project is correct and all necessary information is available.
2. **Compile**: Compiles the source code of the project.
3. **Test**: Tests the compiled source code using a suitable testing framework.
4. **Package**: Packages the compiled code into a distributable format, such as a JAR or WAR file.
5. **Verify**: Runs any checks to verify the package is valid and meets quality criteria.
6. **Install**: Installs the package into the local Maven repository, so it can be used as a dependency in other 
   projects locally.
7. **Deploy**: Copies the final package to the remote repository for sharing with other developers and projects.


### What is the difference between package and install in maven lifecycle?

- `Package`: Creates JAR or WAR file for the project to convert it into a distributable format
- `Install`: Deploys the packaged JAR/ WAR file to the local repository.


### What is plugins in maven, list some plugins.
Maven plugins are components that enhance Maven's capability to manage and build software projects. Plugins are executed during the build process and are configured in the `pom.xml` file of a Maven project. Each plugin is designed to perform specific tasks and can be tied to one or more phases of the Maven lifecycle.
- maven-antrun-plugin
- maven-compiler-plugin
- maven-jar-plugin
- maven-clean-plugin
- maven-install-plugin
- maven-deploy-plugin
- maven-site-plugin



### pom.xml

```xml
  <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>3.3.2</version>
      <relativePath/> <!-- lookup parent from repository -->
    </parent>

  <groupId>com.example</groupId>
  <artifactId>springmvc-demo</artifactId>
  <packaging>jar</packaging>  #war
  <version>1.0-SNAPSHOT</version>
  <name>mvc-demo</name>
	<description>Demo project for Spring Boot</description>
  <url>http://maven.apache.org</url>

<dependencies>
  <!--Mysql数据库驱动-->
  <dependency>
  <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql-connector.version}</version>
  </dependency>
  
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>3.8.1</version>
    <scope>test</scope>
  </dependency>
  ...
</dependencies>
```

produce jar file: **artifactId - version . packaging**

`springmvc-demo-1.0-SNAPSHOT.jar`

`${mysql-connector.version}` use the value confiured in `application.properties`.

