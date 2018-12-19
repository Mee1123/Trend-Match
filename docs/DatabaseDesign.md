# データ設計書
##### 改版履歴
発行日|版数|改版内容
---|---|---
2018/11/27|1.0|初版
2018/12/10|1.1|クラス図の改訂による改版
2018/12/13|1.2|messagesのテーブルを追加,クラス図や仕様書との整合性確認による変更
2018/12/14|2.0|インスペクションを受けての改版

###### keyの表示方法<br>
・主キーはpk(primary key)<br>
・外部キーはfk(foreign key)<br>
・ユニークキーはuk(unique key)

##### データベース名
[trendmatch]


##### テーブル

- users

Field|和名|Type|Null|Key|Default|Extra
---|---|---|---|---|---|---
user_id|ユーザーID|int(11)|no|pk|null|auto_increment
mailaddress|メールアドレス|varchar(40)|no|uk|null|無し
password|パスワード|char(256)|no|無し|null|無し
name|氏名|varchar(20)|no|無し|null|無し
nickname|ニックネーム|varchar(20)|no|無し|null|無し
picturepath|プロフィール画像|varchar(256)|yes|無し|null|
graduate|卒業年度|int(5)|no|無し|null|無し
contact|連絡先|varchar(40)|yes|無し|null|無し
department|所属|varchar(20)|yes|無し|null|無し
occupation_id|職種ID|int(11)|yes|fk|null|無し
sex_id|性別ID|int(11)|yes|fk|null|無し
joboffer_id|内定ID|int(11)|yes|fk|null|無し
freespace|フリースペース|varchar(200)|yes|無し|null|無し
enneagram_1|エニアグラム1|int(5)|yes|無し|null|無し
enneagram_2|エニアグラム2|int(5)|yes|無し|null|無し
enneagram_3|エニアグラム3|int(5)|yes|無し|null|無し
enneagram_4|エニアグラム4|int(5)|yes|無し|null|無し
enneagram_5|エニアグラム5|int(5)|yes|無し|null|無し
enneagram_6|エニアグラム6|int(5)|yes|無し|null|無し
enneagram_7|エニアグラム7|int(5)|yes|無し|null|無し
enneagram_8|エニアグラム8|int(5)|yes|無し|null|無し
enneagram_9|エニアグラム9|int(5)|yes|無し|null|無し
value_id_1|価値観1|int(11)|yes|fk|null|無し
value_id_2|価値観2|int(11)|yes|fk|null|無し
value_id_3|価値観3|int(11)|yes|fk|null|無し



- values

Field|和名|Type|Null|Key|Default|Extra
---|---|---|---|---|---|---
value_id|価値観ID|int(11)|no|pk|null|auto_increment
value_name|価値観名|varchar(50)|no|uk|null|無し


- messages

Field|和名|Type|Null|Key|Default|Extra
---|---|---|---|---|---|---
message_id|メッセージID|int(11)|no|pk|null|auto_increment
send_user_id|送信者ID|int(11)|no|fk|NULL|無し
recieve_user_id|受信者ID|int(11)|no|fk|null|無し
message_contents|メッセージ内容|varchar(500)|yes|無し|null|無し
created_at|送信日時|timestamp(8)|no|無し|current_timestamp|無し

