# Android에서 YOLOv5를 사용한 객체 탐지

## 소개하기

(You Only Look Once)는 가장 빠르고 인기 있는 객체 팀지 모델 중 하나입니다. [YOLOv5](https://github.com/ultralytics/yolov5)는 오픈 소스로 구현된 YOLOv5 버전입니다.
Object Detection with YOLOv5 Android 앱은 2개의 클래스(bollard, electricscooter)를 학습한 best.pt를 PyTorch Torchscript Lite YOLOv5 model로 추출한걸 적용한 것입니다.

* FEP-BEP 구조가 아닌, 딥러닝 학습 결과 모델을 스마트폰 App에 탑재하여 실시간으로 객체 탐지하는 구조

## 참고 Github

* https://github.com/pytorch/android-demo-app

## 시연 영상
