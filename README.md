# Basic-PokémonApp
이 프로젝트는 Jetpack Compose 를 활용해 포켓몬 사진을 보는 앱을 구현합니다.

### 사용 기술
1. Jetpack Compose
2. Hilt
3. Paging
4. Coil
5. Navigation
6. Retrofit
7. Gson

### 주요 기능
- 포켓몬 정보 API 를 조회해 포켓몬 정보를 가져온다
- 가져온 정보를 Main 화면의 LazyColumn 에 띄워 포켓몬 리스트를 노출한다
- 리스트의 보기 버튼을 클릭하면 해당 포켓몬의 아이디를 콜백으로 전달받아 상세페이지로 이동한다
- 상세페이지에선 전달받은 id 로 포켓몬 사진을 조회해 Coil 을 통해 화면에 노출한다

### 작업 내용
- `95e4849` Initial commit
- `92886f5` gitignore 추가
- `7dc50a4` 프로젝트 수준 hilt 플러그인 추가
- `fd1441e` app 모듈 수준 의존성 추가
- `c48fa8c` 앱 진입점 추가
- `1bb26b1` 포켓몬 api interface 와 Response 추가
- `f17c8e9` Dagger-Hilt를 이용한 Retrofit 및 PokeAPI 구성 및 Gson 설정
- `e615d14` PokemonViewModel에 Paging 라이브러리를 활용해 페이징 처리 구현
- `149d52d` MainScreen 에 포켓몬리스트를 LazyColumn 을 활용해 구현
- `9cc01a5` hilt navigation compose 버전 변경
- `54b93b5` MainScreen에 Hilt를 통한 PokemonViewModel 주입
- `e779748` 인터넷 권한 추가
- `9c3c811` MainScreen 에 포켓몬 리스트 보이게 구현
- `57e5df1` (HEAD -> main) DetailScreen 구현

### 미리보기
<img src= "https://github.com/KeunyoungSong/Basic-TodoApp/assets/84883277/d3b89dec-973c-447b-abc4-70ce0822be83" height = "470"/>
