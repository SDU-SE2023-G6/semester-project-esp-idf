import ace from 'ace-builds/src-noconflict/ace';
ace.define('ace/mode/my_custom_mode', ['require', 'exports', 'module', 'ace/lib/oop', 'ace/mode/text', 'ace/mode/my_custom_mode_highlight_rules'], function(require, exports, module) {
  var oop = require("ace/lib/oop");
  var TextMode = require("ace/mode/text").Mode;
  var MyCustomModeHighlightRules = require("ace/mode/my_custom_mode_highlight_rules").MyCustomModeHighlightRules;

  var Mode = function() {
    this.HighlightRules = MyCustomModeHighlightRules;
  };
  oop.inherits(Mode, TextMode);

  exports.Mode = Mode;
});

ace.define('ace/mode/my_custom_mode_highlight_rules', ['require', 'exports', 'module', 'ace/lib/oop', 'ace/mode/text_highlight_rules'], function(require, exports, module) {
  var oop = require("ace/lib/oop");
  var TextHighlightRules = require("ace/mode/text_highlight_rules").TextHighlightRules;

  var MyCustomModeHighlightRules = function() {
    var keywords = "Hello|Int";
    this.$rules = {
        "start": [
            {token: "comment", regex: "\\/\\/.*$"},
            {token: "comment", regex: "\\/\\*", next : "comment"},
            {token: "string", regex: '["](?:(?:\\\\.)|(?:[^"\\\\]))*?["]'},
            {token: "string", regex: "['](?:(?:\\\\.)|(?:[^'\\\\]))*?[']"},
            {token: "constant.numeric", regex: "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"},
            {token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
        ],
        "comment": [
            {token: "comment", regex: ".*?\\*\\/", next : "start"},
            {token: "comment", regex: ".+"}
        ]
    };
  };

  oop.inherits(MyCustomModeHighlightRules, TextHighlightRules);
  exports.MyCustomModeHighlightRules = MyCustomModeHighlightRules;
});