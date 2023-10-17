import { Component, OnInit } from '@angular/core';
import { Recipe } from './recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [
    new Recipe('A Test Recipe', 
    'This is just a test recipe', 
    // 'https://stordfkenticomedia.blob.core.windows.net/df-us/rms/media/recipemediafiles/recipes/retail/x17/17244-caramel-topped-ice-cream-dessert-600x600.jpg'
    // 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVKXn02Zto9sMj3vjFbtjGmZF3CO_3b0D4Qb_vpBQaqXidbRxJU5PLkkUfKwa7gkseOSI&usqp=CAU'
    // 'https://cdn.pixabay.com/photo/2014/12/21/23/28/recipe-575434_960_720.png'
    // 'https://cdn-icons-png.flaticon.com/512/1041/1041373.png'
    'https://www.freeiconspng.com/uploads/notebook-recipe-icon-18.png'
    // 'http://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_navQz1rgij5uRb1_0z-CzU_SDoF5x9TGbeYD5VmyocM5PbcdmlLg_alvBSfHAcVY5Dw&usqp=CAU'
    // 'https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg'
    ),
    new Recipe('A Test Recipe', 
    'This is just a test recipe', 
    // 'https://stordfkenticomedia.blob.core.windows.net/df-us/rms/media/recipemediafiles/recipes/retail/x17/17244-caramel-topped-ice-cream-dessert-600x600.jpg'
    // 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVKXn02Zto9sMj3vjFbtjGmZF3CO_3b0D4Qb_vpBQaqXidbRxJU5PLkkUfKwa7gkseOSI&usqp=CAU'
    // 'https://cdn.pixabay.com/photo/2014/12/21/23/28/recipe-575434_960_720.png'
    // 'https://cdn-icons-png.flaticon.com/512/1041/1041373.png'
    // 'https://www.freeiconspng.com/uploads/notebook-recipe-icon-18.png'
    // 'http://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_navQz1rgij5uRb1_0z-CzU_SDoF5x9TGbeYD5VmyocM5PbcdmlLg_alvBSfHAcVY5Dw&usqp=CAU'
    'https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg'
    )
  ];

  constructor() {

  }

  ngOnInit(): void {
    
  }

}
