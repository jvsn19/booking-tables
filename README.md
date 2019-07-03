# booking-tables

Aplicativo para realizar reservas de mesas em restaurantes. Primeiramente o usuário poderá ver o menu do restaurante, algumas reviews e um mapa geral do local disponibilizado pelo restaurante, com marcações para mesas e o usuário poderá visualizar as mesas disponíveis para reservas.

## Principais Classes

- FirebaseManager: lida com a comunicação com o FIrebase

- RestaurantModel, DishModel, RatingModel: modelos dos dados da aplicação. As três classes implementam a interface Parceable (funciona semelhante a uma serialização) e, para evitar o boilerplate dos métodos do Parceable, uma anotação @Parcelize deve ser adicionado à classe:

  ```kotlin
  @Parcelize
  data class DishModel(val name: String, val price: Double, val rating: Int) : Parcelable
  ```

  - RestaurantModel: Contém nome, endereço, um array de RatingModel, um par de coordenadas (lat, long), um array de DishModel e um array de RatingModel

  - DishModel: Contém nome, preço

  - RatingModel: Contém comentário e o rating

- MapsActivity: Activity que implementa a API de mapas do Google. A partir dos restaurantes cadastrados o mesmo plota markers relativo ao lat, long de cada restaurante e, ao clicar em um marker, a Activity inicia uma intent para a RestaurantActivity e adiciona o restaurante referente àquela posição na intent (putExtra para cada parâmetro do restaurante ou um putExtra com o restaurante, passando o tipo Parceable)

- 

## Helping

## TabLayout with RecyclerView

Library to add a TabLayout with RecyclerView. Useful when having

- Many tabs layout
- Infinite loop scrolling (imitated)

[RecyclerTabLayout](https://github.com/nshmura/RecyclerTabLayout)

### Running With Android Studio and Redmi devices

#### INSTALL_FAILED_USER_RESTRICTED error

If this error is occurring, do the following steps:

- *Settings -> Additional Settings -> Developer options*
- Turn off "MIUI optimization" and Restart
- Turn On "USB Debugging"
- Turn On "Install via USB"

[StackOverFlow Reference](https://stackoverflow.com/questions/47239251/install-failed-user-restricted-android-studio-using-redmi-4-device
)
