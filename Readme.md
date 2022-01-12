# Validador de c&eacute;dulas de identidad de Uruguay

## Instalación

1. Uso mediante Maven en el archivo `pom.xml`:

```yml
  <dependency>
    <groupId>com.fabdelgado</groupId>
    <artifactId>ciuy</artifactId>
    <version>1.2</version>
  </dependency>
```

2. Uso mediante Gradle:

```yml
  implementation 'com.fabdelgado:ciuy:1.2'
```

## Modo de uso

### Validar Ci
```java
import com.fabdelgado.ciuy.*;

Validator validator = new Validator();
validator.validateCi("3.566.999-2");
```

### Validar digito verificador
```java
import com.fabdelgado.ciuy.*;

Validator validator = new Validator();
validator.validationDigit("3.566.999-2");
```

### Generar Ci aleatoria
```java
import com.fabdelgado.ciuy.*;

Validator validator = new Validator();
validator.randomCi();
```

### Limpiar caracteres
```java
import com.fabdelgado.ciuy.*;

Validator validator = new Validator();
validator.cleanCi("3.566.999-2");
```

## Contribución

1. Realice un fork del proyecto (<https://github.com/fabdelgado/ciuy/fork>)
2. Establezca una rama para trabajar (`git checkout -b my-new-feature`)
3. Confirme sus cambios (`git commit -am 'Add some feature'`)
4. Suba los cambios (`git push origin my-new-feature`)
5. Cree un nuevo Pull Request