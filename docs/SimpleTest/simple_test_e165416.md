# 単体テスト報告書

作成：E16-5416　渡辺みどり<br>

改版履歴

版数|日時|内容
---|---|---
1.0|2019/1/14|初版

## 初めに
機能名に関しては「機能名(機能仕様書の該当機能番号)」と記述.  


## テスト内容

### アクター：利用者(アカウントあり)

#### 機能名:「退会(5.1.3)」


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|退会確認画面で「はい」を押すと,データベースのユーザーテーブルからセッションに保持されているユーザーIDと一致するユーザーを削除することができる|1/13|OK|
|2|退会した後にログイン画面へと遷移することができる|1/13|OK|



### アクター:管理者

#### 機能名:「ユーザー削除(5.2.1)」


|番号|テスト内容|テスト実施日|結果|備考|
|:--:|--|:--:|:--:|:--:|
|1|ユーザー削除確認画面で「はい」を押すと,データベースのユーザーテーブルから削除対象のユーザーIDと一致するユーザーを削除することができる|1/13|OK|


