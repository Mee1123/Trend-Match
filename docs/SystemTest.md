
# システムテスト

改版履歴

版数|日時|内容
---|---|---
1.0|2019/1/16|初版

---



## はじめに

アクターを結果表の前に記述.

|番号|テスト内容|テスト実施者|テスト実施日|結果|備考|
|:--:|:--:|:--:| :--:|:--:|:--:|
|項番|テストの内容(機能仕様書の項番)|テスト実施者を記述|テスト実施日を記述|結果欄は、テスト内容が正しく動作した時はOK, 動作しなかった時はNGを記録.正しく動作しなかった場合には、修正して、正しく動作することを確認して、その実施日と結果を改めて記録する.|備考がある場合は記述.<br>未実装のためテストできない場合は未実施の旨を記述|


## テストを実施した環境
+ OS
    + Windows10
    + MacOS
+ 使用ブラウザ
    + Google Chrome

+ リリースノート　v1.0.0


## システムテスト結果

### アクター：利用者

|番号|テスト内容|テスト実施者|テスト実施日|結果|備考|
|:--:|:--:|:--:| :--:|:--:|:--:|
|1|ユーザー情報の登録ができる(5.1.1)|松原|1/16|OK||
|2|ユーザー情報の編集ができる(5.1.2)|松原|1/16|OK|編集はできるが不正値を入力すると文字化けが起こる|
|3|退会できる(5.1.3)|渡辺|1/16|OK||
|4|アカウント情報の登録ができる(5.1.4)|松原|1/16|OK||
|5|アカウント情報の編集ができる(5.1.5)|松原|1/16|OK|編集はできるが,不正値がある場合500エラー|
|6|自己分析の実施ができる(5.1.6)|松原|1/16|OK||
|7|マッチングを行うことができる(5.1.7)|松原|1/16|OK||
|8|マッチング結果を閲覧することができる(5.1.8)|松原|1/16|OK||
|9|ダイレクトメッセージが使える(5.1.9)|松原|||v1.0.0では未実装のためテスト未実施|
|10|通報できる(5.1.10)|渡辺|||v1.0.0では未実装のためテスト未実施|
|11|価値観の登録が行える(5.1.11)|松原|1/16|OK||
|12|アカウント情報の閲覧ができる(5.1.12)|松原|1/16|OK|自分のアカウント情報は閲覧できるが,他人のアカウント閲覧はv1.0.0では未実装のためテスト未実施|
|13|アカウント検索ができる(5.1.13)|松原|1/16|OK||
|14|アカウント一覧表示ができる(5.1.14)|松原|1/16|OK||
|15|ログインができる(5.3.1)|松原|1/16|OK||
|16|ログアウトができる(5.3.2)|松原|1/16|OK||



### アクター：管理者

|番号|テスト内容|テスト実施者|テスト実施日|結果|備考|
|:--:|:--:|:--:| :--:|:--:|:--:|
|1|ユーザーの削除ができる(5.2.1)|渡辺|1/16|OK|ただしv1.0.0では管理者以外のアクターからも削除可能|
|2|一斉連絡ができる(5.2.2)|松原|||v1.0.0では未実装のためテスト未実施|
|3|ログインができる(5.3.1)|松原|1/16|OK||
|4|ログアウトができる(5.3.2)|松原|1/16|OK||



### 非機能

|番号|テスト内容|テスト実施者|テスト実施日|結果|備考|
|:--:|:--:|:--:| :--:|:--:|:--:|
|1|XSS対策がされている(6.1.1)|古田|||v1.0.0では実装が不十分のため未実施|
|2|ロールベースアクセス制御がされている(6.1.2)|古田|1/16|ERROR|管理者の機能であるユーザー削除機能を,利用者も使用することができている.|
|3|URL直打ちでのJSPファイルへのアクセスが禁止されている(6.1.3)|古田|1/16|ERROR|退会確認画面,ログアウト画面にアクセスできてしまう.その他のページはユーザー情報が必要な画面なのでアクセスはできなくなっているが,ログインページにとばしたい.
|4|タイムアウト時間の設定がされている(6.1.4)|小野|1/16|OK||