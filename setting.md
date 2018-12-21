## 環境構築
システムプログラミングのプロジェクトのテンプレートです．  
このプロジェクトは動的Webプロジェクトで作成しています．

## 言語と動作環境

- `java 1.8+`
- `Apach Tomcat 8.0+`
- `Eclipse`

## ローカル環境への取り込み方

1. プロジェクトのクローンの準備

URLをコピーしておいてください．

![クローン](https://user-images.githubusercontent.com/27722351/47001011-7f735600-d164-11e8-9025-7f3f96c226c2.png)

2. Eclipseにプロジェクトをインポート

Eclipseにプロジェクトをインポートします．  
「ファイル」 → 「インポート」 → 「Git : Gitからプロジェクト」を選択．

![インポート](https://user-images.githubusercontent.com/27722351/47001189-d2e5a400-d164-11e8-98e1-15fcb5d5d9fb.png)

「クローンURL」を選択．※Eclipseのバージョンによっては「URLから複製」と表示されています．

![クローンURL](https://user-images.githubusercontent.com/27722351/47001190-d2e5a400-d164-11e8-9895-5a5cc3152964.png)

先ほどコピーしておいたURLを「ローケーション」欄に貼り付けてください．※自動で入力されてる場合もあります．  
貼り付けると「ホスト」，「リポジトリ・パス」は自動で入力されます．

![ロケーション](https://user-images.githubusercontent.com/27722351/47001318-222bd480-d165-11e8-8453-6c6806b4bc94.png)

「次へ」を押すとGitHubのIDとパスワードの入力を要求されます．  
入力後，プロジェクトを配備するディレクトリを指定する画面に移ります．**このディレクトリは起動しているEclipseのworkspaceを指定ください．**
 
![ディレクトリ](https://user-images.githubusercontent.com/27722351/47001717-155bb080-d166-11e8-83bd-d6b001d0073f.png)

次に「プロジェクトのインポートするためのウィザード」を選択します．  
「新規プロジェクトウィザードを使用してインポート」にチェックをしてください．

![プロジェクトウィザード](https://user-images.githubusercontent.com/27722351/47002057-e560dd00-d166-11e8-9476-43455fc85949.png)

プロジェクトの形式は「Web : 動的Webプロジェクト」を選択してください．

![プロジェクト選択](https://user-images.githubusercontent.com/27722351/47002259-71730480-d167-11e8-9d5d-32ffd5576047.png)

プロジェクト名はGitHubのプロジェクト名と同じにしてください．  
ターゲット・ランタイムは `Tomcat 8.0`以上を指定ください．

![プロジェクト設定](https://user-images.githubusercontent.com/27722351/47002453-ff4eef80-d167-11e8-942e-fe4e9fe8e509.png)


3. ビルドと実行

「実行」 -> 「サーバーで実行」  
Tomcatが正常に起動したことを確認したら，以下のURLにアクセス．

http://localhost:8080/SE18G1

![サンプル画面](https://user-images.githubusercontent.com/27722351/47002747-bfd4d300-d168-11e8-8e27-6863fa854a97.png)

