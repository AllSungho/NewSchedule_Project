# API 명세서
### 회원가입
* POST /signups
* 회원가입 API
* 요청 예시:
```json
{
    "name" : "이름1",
    "email" : "이메일1",
    "password" : "비밀번호1"
}
```


### 로그인
* POST /logins
* 로그인 API
* 요청 예시:
```json
{
    "email" : "이메일1",
    "password" : "비밀번호1"
}
```

### 로그아웃
* POST /logouts
* 로그아웃 API

### 유저 전체 조회
* GET /users
* 전체 사용자 조회 API
* 응답 예시:
```json
[
    {
        "id": 1,
        "name": "이름1",
        "email": "이메일1",
        "createdAt": "2025-08-13T10:24:46.967685",
        "modifiedAt": "2025-08-13T10:24:46.967685"
    }
]
```

### 유저 단건 조회
* GET /users/{userId}
* 유저 단건 조회 API
* 응답 예시:
```json
{
    "id": 1,
    "name": "이름1",
    "email": "이메일1",
    "createdAt": "2025-08-13T10:24:46.967685",
    "modifiedAt": "2025-08-13T10:24:46.967685"
}
```

### 유저 수정
* PUT /users/{userId}
* 유저 수정 API
* 요청 예시:
```json
{
    "name" : "이름수정",
    "email" : "이메일수정",
    "password" : "비밀번호수정"
}
```

### 유저 삭제
* DELETE /users/{userId}
* 유저 삭제 API

### 스케줄 저장
* POST /users/{userId}/schedules
* 스케줄 저장 API
* 요청 예시:
```json
{
    "name" : "스케줄 이름1",
    "title" : "제목1",
    "content" : "내용1"
}
```

### 스케줄 전체 조회
* GET /users/{userId}/schedules
* 해당 유저의 스케줄 전체 조회 API
* 응답 예시:
```json
[
    {
        "id": 1,
        "name": "스케줄 이름1",
        "title": "제목1",
        "content": "내용1",
        "createdAt": "2025-08-13T10:31:38.467836",
        "modifiedAt": "2025-08-13T10:31:38.467836"
    }
]
```

### 스케줄 단건 조회
* GET /users/{userId}/schedules/{scheduleId}
* 스케줄 단건 조회 API
* 응답 예시:
```json
{
    "id": 1,
    "name": "스케줄 이름1",
    "title": "제목1",
    "content": "내용1",
    "createdAt": "2025-08-13T10:31:38.467836",
    "modifiedAt": "2025-08-13T10:31:38.467836"
}
```

### 스케줄 수정
* PUT /users/{userId}/schedules/{scheduleId}
* 스케줄 수정 API
* 요청 예시:
```json
{
    "name" : "스케줄 이름2",
    "title" : "제목2",
    "content" : "내용2"
}
```

### 스케줄 삭제
* DELETE /users/{userId}/schedules/{scheduleId}
* 스케줄 삭제 API

### 댓글 생성
* POST /schedules/{scheduleId}/comments
* 댓글 생성 API
* 요청 예시:
```json
{
    "content" : "내용 생성1"
}
```

### 댓글 전체 조회
* GET /comments?schedule={scheduleId}
* 댓글 전체 조회 API
* 응답 예시:
```json
[
    {
        "id": 1,
        "content": "내용 생성1",
        "createdAt": "2025-08-14T09:08:50.131095",
        "modifiedAt": "2025-08-14T09:08:50.131095"
    }
]
```

### 댓글 단건 조회
* GET /comments/{commentId}
* 댓글 단건 조회 API
* 응답 예시:
```json
{
    "id": 1,
    "content": "내용 생성1",
    "createdAt": "2025-08-14T09:08:50.131095",
    "modifiedAt": "2025-08-14T09:08:50.131095"
}
```

### 댓글 수정
* PUT /comments/{commentId}
* 댓글 수정 API
* 응답 예시:
```json
{
    "id": 1,
    "content": "내용 변경",
    "createdAt": "2025-08-14T09:08:50.131095",
    "modifiedAt": "2025-08-14T09:08:50.131095"
}
```

### 댓글 삭제
* DELETE /comments/{commentId}
* 댓글 삭제 API

# ERD
https://www.erdcloud.com/d/LCobLGyc84rmKZRYi
