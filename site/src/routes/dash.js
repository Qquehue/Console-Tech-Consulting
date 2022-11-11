var express = require("express");
var router = express.Router();

var dashController = require("../controllers/dashController");

router.get("/", function (req, res) {
    dashController.testar(req, res);
});

router.get("/listarTotem", function (req, res) {
    dashController.listarTotem(req, res);
});

module.exports = router;