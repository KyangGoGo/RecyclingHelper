## RecyclingHelper (분리수거 도우미) 

<img src="https://img.shields.io/badge/language-Java-007396?style=flat"> <img src="https://img.shields.io/badge/license-MIT-6DB33F?style=flat"> <img src="https://img.shields.io/badge/license-MIT-007396?style=flat"> 

<img src="https://img.shields.io/badge/Android-3DDC84?style=flat&logo=Android&logoColor=white"> <img src="https://img.shields.io/badge/TensorFlowLite-FF6F00?style=flat&logo=TensorFlow&logoColor=white">

실시간 이미지 인식을 통하여 재활용 쓰레기 품목별 분비배출방법을 안내하는 안드로이드 어플리케이션

## 주의
이미지 인식 모델(model.tflite)은 용량이 커서 Google Drive에 저장했습니다.
### 모델 다운로드
https://drive.google.com/file/d/1YUVO1jt2CY6HmuG2oye1tcEh0DHDYlGs/view?usp=sharing
### 애플리케이션에 적용
app/src/main/assets 디렉토리에 다운받은 model.tflite 저장

## 사용 방법
### 재활용 쓰레기 인식
<img src="https://user-images.githubusercontent.com/27201209/134797411-f420c605-9079-4b72-8daa-ca5136708ac0.jpg" width="300px" height="auto"/>

1. 인식할 재활용 쓰레기에 카메라를 둔다.
2. 앱 하단바에 정확도를 기준으로 세 가지 인식한 품목이 나타난다.

<img src="https://user-images.githubusercontent.com/27201209/134797413-728c0b34-e9c1-45fb-b8fb-27d8c02bb095.jpg" width="300px" height="auto"/>

3. 하단바를 위로 올리면 랜덤 꿀팁이 나온다!

### 간단한 정보 보기
<img src="https://user-images.githubusercontent.com/27201209/134797494-2b68bb7c-ef75-4dc7-96e4-130df3f1f433.jpg" width="300px" height="auto"/>

1. 앱 하단바의 인식한 품목버튼을 누른다.

<img src="https://user-images.githubusercontent.com/27201209/134797470-f49e077a-62b8-43ef-b75f-b5195aa0268b.jpg" width="300px" height="auto"/>


2. 간단한 정보를 볼 수 있다.

### 자세한 정보 보기
1. 품목별 자세한 정보를 보여준다.

<img src="https://user-images.githubusercontent.com/27201209/134797470-f49e077a-62b8-43ef-b75f-b5195aa0268b.jpg" width="300px" height="auto"/>

2. 간단한 정보 보기에서 자세히 보기 버튼을 누른다.

<img src="https://user-images.githubusercontent.com/27201209/134797421-37ea2533-7219-4c9c-95d6-50a9713c474c.jpg" width="300px" height="auto"/>

3. 자세한 품목별 배출 방법

<img src="https://user-images.githubusercontent.com/27201209/134797420-50a269a9-2947-459d-b1d9-26e42609a2d5.jpg" width="300px" height="auto"/>

4. 주의해야할 점

<img src="https://user-images.githubusercontent.com/27201209/134797416-da60795e-bebe-44c4-942e-99d443546926.jpg" width="300px" height="auto"/>

5. 자주 묻는 질문

## 현재 분류 가능한 재활용품
1. 비닐
2. 스티로폼
3. 유리병
4. 종이
5. 캔류
6. 폐전지
7. 플라스틱
8. 형광등
