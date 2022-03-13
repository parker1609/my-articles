> Git 쓰면서 겪었던 상황과 이를 해결한 명령어 모음입니다.

## Git Command Help

터미널 환경에서 GIT을 사용할 경우 명령어로 쉽게 git command 정보를 알 수 있다. 바로 `--help` 옵션을 사용하는 것이다.

**Git add 명령어 정보 보기**

```bash
git add --help
```

Git checkout 명령어 정보 보기

```bash
git checkout --help
```

## Git Branch

### Local Branch 이름 변경하기

```bash
git branch -m <변경 전 branch name> <변경 후 branch name>
```

### Local Branch 삭제하기

```bash
git branch -D <local branch name>
```

### Remote Branch 참고하기

Remote branch를 수정하지 않고 단지 읽고만 싶은 경우

```bash
git checkout <remote branch 이름>
```

위 명령어를 수행하면 해당 branch는 **detached HEAD 상태**가 되며, 로컬 환경에서 해당 branch의 내용을 변경할 수는 있지만, commit과 push와 같은 명령어는 사용할 수 없다.

다른 branch로 checkout하면 해당 branch는 사라진다.

### Remote Branch 가져오기

**Local git remote 정보 최신화하기**

```bash
git remote update
```

**Remote Branch 이름 그대로 가져오기**

```bash
git checkout -t origin/feature/issue-1
```

`git branch -r` 또는 `git branch -a` 목록 중 origin/feature/issue-1 원격 브랜치를 가져온다.

**Remote Branch 이름 변경한 후 가져오기**

```bash
git checkout -b <변경할 branch 이름> origin/feature/issue-1
```

`-b` : branch를 만든 후 가져오기

> [https://cjh5414.github.io/get-git-remote-branch/](https://cjh5414.github.io/get-git-remote-branch/)

### Remote Branch에 push하기

Remote repository 목록보기

```bash
git remote -v
```

Local branch 이름과 remote branch 이름이 같은 경우

```bash
git push origin <local branch 이름>
```

Local branch 이름과 remote branch 이름이 다른 경우

```bash
git push origin <local branch 이름>:<remote branch 이름>
```

Remote branch가 존재하지 않은 경우 이를 만들면서 push하는 경우

```bash
git push -u origin <local branch 이름>
```

> [https://devconnected.com/how-to-push-git-branch-to-remote/](https://devconnected.com/how-to-push-git-branch-to-remote/)

### Remote Branch에 잘못 올라간 파일 삭제하기

Remote repository와 local repository에 있는 파일을 삭제한다.

```bash
git rm <file 이름>
```

Remote repository에 있는 파일을 삭제한다. (local repository는 삭제하지 않는다.)

```bash
git rm --cached <file 이름>
```

### Remote Branch에 올라간 commit 취소하기

[원격 저장소에 올라간 커밋 되돌리기](https://jupiny.com/2019/03/19/revert-commits-in-remote-repository/)

## Git Add

### git add 취소하기

git add 전체 취소하기

```bash
git reset HEAD
```

git add 특정 파일 취소하기

```bash
git reset HEAD <file 이름>
```

## Git Commit

### 마지막 commit 정보 변경하기

마지막 commit에 대한 정보를 변경할 때는 `-amend` 옵션을 사용한다.

```bash
git commit --amend
```

위 명령어를 사용하면 마지막 commit의 정보와 함께 자동으로 텍스트 편집기가 열린다. 여기서 수정할 수 있는 것은 **commit 메시지 뿐**이다. commit의 정보를 변경하여 저장하여도 반영되지 않는다.

commit 날짜 변경 임의의 날짜로 변경

```bash
git commit --amend --no-edit --date="Mon 20 Aug 2020 19:19:19 KST"

git commit --amend --no-edit --date="Mon 26 Apr 2021 20:17:19 KST"
git commit --amend --no-edit --date="Mon 26 Apr 2021 21:08:34 KST"
git commit --amend --no-edit --date="Mon 26 Apr 2021 21:33:02 KST"
```

- 월: Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
- 요일: Sun, Mon, Tue, Wed, Thu, Fri, Sat

현재 날짜로 변경

```bash
git commit —amend —no-edit —date="$(date)"
```

작성자 변경

```bash
git commit --amend --author="Author Name <email@address.com>" --no-edit
```

[https://stackoverflow.com/questions/3042437/how-to-change-the-commit-author-for-one-specific-commit](https://stackoverflow.com/questions/3042437/how-to-change-the-commit-author-for-one-specific-commit)

### 여러 commit 정보 변경하기

rebase 명령어를 사용하면 여러 commit 정보를 한꺼번에 변경할 수 있다.

[How to change the commit author for one specific commit?](https://stackoverflow.com/questions/3042437/how-to-change-the-commit-author-for-one-specific-commit/28845565)

[이미 커밋된 내용에서 author(작성자) 수정하기](https://jojoldu.tistory.com/120)

## Git Merge

### git squash merge

#### 머지된 커밋 이력 남기기

```bash
git checkout main
git merge --squash sub
git commit
```

- 브랜치 sub -> 브랜치 main 으로 머지

`git commit` 명령어를 수행하면 커밋 메시지를 수정하는 에디터가 실행되며, 머지하려는 브랜치의 커밋 이력이 담겨있다. 자유롭게 수정하여 커밋하자.

#### 커밋 메시지 한 줄로 하기

```bash
git checkout main
git merge --squash sub
git commit -m "commit message"
```

- <https://stackoverflow.com/questions/5308816/how-can-i-merge-multiple-commits-onto-another-branch-as-a-single-squashed-commit>
- <https://im-developer.tistory.com/182>

### git pull or git merge 취소하기

```bash
git reset --hard ORIG_HEAD
git reset --merge ORIG_HEAD
```

- ORIG_HEAD: pull 또는 merge를 수행할 때 이전에 작업하던 곳의 HEAD 위치를 ORIG_HEAD라는 이름으로 저장한다.

## Github Pull Request

### PR 번호로 불러오는 설정하기

*~/.gitconfig*에 아래 내용을 입력하여 저장한다.

```bash
# for github remotes
[alias]
  pr  = "!f() { git fetch -fu ${2:-$(git remote |grep ^upstream || echo origin)} refs/pull/$1/head:pr/$1 && git checkout pr/$1; }; f"
  pr-clean = "!git for-each-ref refs/heads/pr/* --format='%(refname)' | while read ref ; do branch=${ref#refs/heads/} ; git branch -D $branch ; done"
# for bitbucket/stash remotes
  spr  = "!f() { git fetch -fu ${2:-$(git remote |grep ^upstream || echo origin)} refs/pull-requests/$1/from:pr/$1 && git checkout pr/$1; }; f"
```

그 후 아래 명령어로 해당 PR 번호에 해당하는 remote branch를 checkout하여 local 환경에 가져올 수 있다.

```bash
git pr <PR 번호> <remote repository 이름>
```

### Pull Requests 충돌 해결

```bash
git remote add upstream

git fetch upstream 자신의 github_id

git reset --hard upstream/자신의 github_id

git push --force [remote repository]
```

> [https://planbs.tistory.com/entry/Git-Pull-request에서-발생하는-충돌-해결하기](https://planbs.tistory.com/entry/Git-Pull-request%EC%97%90%EC%84%9C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EC%B6%A9%EB%8F%8C-%ED%95%B4%EA%B2%B0%ED%95%98%EA%B8%B0)

## Git Rebase

[Git Rebase 제대로 알고 쓰기 (feat. cherry-pick)](https://readystory.tistory.com/151)

### cherry-pick

[Git cherry-pick 사용법](https://medium.com/react-native-seoul/git-cherry-pick-%EC%82%AC%EC%9A%A9%EB%B2%95-fe1a3346bd27)

## Git Stash

현재 작업을 임시로 저장하고 비우기(stash)

```bash
git stash
git stash save
```

stash 목록

```bash
git stash list
```

### stash 가져오기

가장 최근 stash된 목록 가져오기

```bash
git stash apply
```

stash 목록 중 선택하여 가져오기(stash 목록 형식: stash@{<번호>})

```bash
git stash apply <가져올 stash 목록>
```

### stash 삭제하기

가장 최근 stash된 목록 삭제하기

```bash
git stash drop
```

stash 목록 중 선택하여 삭제하기

```bash
git stash drop <삭제할 stash 목록>
```

가장 최근 stash된 목록을 적용하고 삭제하기

```bash
git stash pop
```

### git stash 적용 후 충돌난 경우

[병합 충돌을 일으키는 git stash pop 실행 취소](https://procodes.tistory.com/674)

## Git 환경설정

### git 현재 계정 정보 확인하기

사용자 이름 확인하기

```bash
git config user.name
```

사용자 이메일 확인하기

```bash
git config user.email
```

### git 계정 정보 변경하기

사용자 이름 변경하기

```bash
git config --global user.name <변경할 사용자 이름>
```

사용자 이메일 변경하기

```bash
git config --global user.email <변경할 이메일>
```

gitconfig 파일에서 변경하기

```bash
vi ~/.gitconfig
```

위 명령어로 편집기를 열면 user 정보를 볼 수 있다. 여기서 변경을 원하는 내용을 삽입하고 저장하면 된다.

~/.gitconfig 파일은 `git config --global` 로 읽을 수 있는 정보들이 저장되어 있는 파일이다.

> [https://git-scm.com/book/ko/v2/시작하기-Git-최초-설정](https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EC%B5%9C%EC%B4%88-%EC%84%A4%EC%A0%95)

### .gitignore 적용

*.gitignore* 파일에 git이 추적하고 싶지 않은 파일을 추가한 후 아래 명령어를 수행하면 바로 적용할 수 있다. 

- 모든 파일이 Staged 상태여야 함(아닐시, `git add .` 수행)

```bash
git rm -r --cached .
git add .
git commit -m "<commit message>"
```

위 명령어는 remote branch로 이미 올라간 repository에 *.gitignore*을 적용하고 싶은 경우에도 사용할 수 있다.

> [https://jojoldu.tistory.com/307](https://jojoldu.tistory.com/307)

### Github 비밀번호 변경 시 local 환경 업데이트하기

Github의 비밀번호를 변경한 후 Github Repository에 push와 같은 명령어로 호출을 할 때 사용자 정보가 일치하지 않는다는 에러가 발생한다. 이러한 경우 다음 과정을 수행한다.

Local 환경의 Github 인증 초기화하기

```bash
git config --unset credential.helper
```

초기화한 후 git push 명령어 수행하기

```bash
git push <remote repository 이름> <local branch 이름>:<remote branch 이름>
```

인증 정보를 초기화한 후 git push를 수행하면 **Github username과 password를 재입력받는다.** 이 때 변경한 비밀번호를 입력하면 그 후에는 이전과 같이 별도의 정보 입력없이 push가 가능하다.

> [https://jojoldu.tistory.com/467](https://jojoldu.tistory.com/467)