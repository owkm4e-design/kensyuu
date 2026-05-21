let maxDate = new Date();

maxDate.setMonth(maxDate.getMonth() + 3);

flatpickr('#fromCheckinDateToCheckoutDate', {
    mode: "range",//カレンダーの範囲選択モードを有効にする
    locale: 'ja',//	日本語にする
    minDate: 'today',//選択できる最小の日付を当日にする
    maxDate: maxDate//選択できる最大の日付を3か月後にする
});