$(function() {
    $("")
$.ajax({
    type: 'POST', // HTTPリクエストメソッドの指定
    url: '/getGroup', // 送信先URLの指定
    async: true, // 非同期通信フラグの指定
    dataType: 'json', // 受信するデータタイプの指定
    timeout: 10000, // タイムアウト時間の指定
    data: {
        id: 1,
        name: 'brisk' // クエリパラメータの指定。サーバーに送信したいデータを指定
    }
})
    .done(function(data) {
        // 通信が成功したときの処理
    })
    .fail(function() {
        // 通信が失敗したときの処理
    })
    .always(function() {
    // 通信が完了したときの処理
});
});
