if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Testkt'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Testkt'.");
}
var Testkt = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    println('frfrfcv');
  }
  _.main_kand9s$ = main;
  Kotlin.defineModule('Testkt', _);
  main([]);
  return _;
}(typeof Testkt === 'undefined' ? {} : Testkt, kotlin);
