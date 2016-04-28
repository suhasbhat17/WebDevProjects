var express = require('express');
var app = express();

//app.configure(function () {
    app.use(express.static(__dirname + '/'));
//});

app.get('/customers/:id', function(req,res){
    var customerId = parseInt(req.params.id);
    var data = {};
    for(var i=0, len=customers.length;i<len;i++){
        if(customers[i].id === customerId){
            data = customers[i];
            break;
        }
    }
    res.json(data);
});

app.get('/customers', function(req,res) {
    res.json(customers);
});

app.listen(8080);

console.log('Express listening on port 8080');

var customers = [{
      id: 1,
      name: 'suhas',
      buy: '02-12-2001',
      cost: '200',
      orders: [{
        id: 1,
        product: 'shoes',
        total: 200
      }]
    }, {
      id: 2,
      name: 'datta',
      buy: '04-12-2017',
      cost: '234',
      orders: [{
        id: 2,
        product: 'headphones',
        total: 200
      }]
    }, {
      id: 3,
      name: 'vivek',
      buy: '23-05-1991',
      cost: '5000',
      orders: [{
        id: 3,
        product: 'kindle',
        total: 200
      }]
    }];