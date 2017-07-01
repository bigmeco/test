if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'testKotlinjs'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'testKotlinjs'.");
}
var testKotlinjs = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    println('Hello JavaScript!');
  }
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('testKotlinjs', _);
  return _;
}(typeof testKotlinjs === 'undefined' ? {} : testKotlinjs, kotlin);
