const createTableRow = (title, description, targetDate) =>
`
<tr>
    <td>${title}</td>
    <td>${description}</td>
    <td>${targetDate}</td>
</tr>
`;

class TodoController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array
//    addTodo(title, description, targetDate)
//    {
//        const todoObj = {
//            name: name,
//            description: description,
//            targetDate: targetDate
//        };
//
//        this._items.push(todoObj);
//    }

     //method to add the items into the database
            addTodo(title, description, targetDate)
            {
                let productController = this;
                const formData = new FormData();
                formData.append('title', title);
                formData.append('description', description);
                formData.append('targetDate', targetDate);

               fetch('http://localhost:8080/todos/add', {
                     method: 'POST',
                     body: formData
                     })
                     .then(function(response) {
                         console.log(response.status); // Will show you the status
                         if (response.ok) {
                             alert("Successfully Added To-do!");
                         }
                         else {
                            throw Error(response.statusText);
                         }
                     })
                     .catch((error) => {
                         console.error('Error:', error);
                         alert("Error adding to-do")
                     });
            }





    //This method will do the fetch method to fetch data from database using the REST API endpoint from SpringBoot
    displayItem()
    {
        let todoController = this;
        todoController._items = [];

        //fetch data from database using the REST API endpoint from Spring Boot
        fetch('/todos/all')
            .then((resp) => {
                return resp.json();
            })
            .then(function(data) {
                console.log(data);
                data.forEach(function (item, index) {
                    const itemObj = {
                        id: item.id,
                        title: item.title,
                        description: item.description,
                        targetDate: item.targetDate
                   };
                    todoController._items.push(itemObj);
              });

              todoController.renderProductPage();

            })
            .catch(function(error) {
                console.log(error);
            });
    }

    //Based on the item fetched from the displayItem() method and show the products in the product page
    renderProductPage()
    {
        let productHTMLList = [];
        
        for (let i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createTableRow(item.title, item.description, item.targetDate);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;
    }


}   //End of ProductsController class
