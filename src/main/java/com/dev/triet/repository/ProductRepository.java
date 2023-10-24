package com.dev.triet.repository;

import com.dev.triet.dto.ProductSearchDataModel;
import com.dev.triet.entities.Categories;
import com.dev.triet.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @PersistenceContext
    default Class<ProductSearchDataModel> clazz() {
        // TODO Auto-generated method stub
        return ProductSearchDataModel.class;
    }

    Categories findByCategoriesId(Integer categoriesId);


    // findDistinct là tìm kiếm và loại bỏ đi các đối tượng trùng nhau
//    List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
//    List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

    // IgnoreCase là tìm kiếm không phân biệt hoa thường, ví dụ ở đây tìm kiếm lastname
    // lastname sẽ không phân biệt hoa thường
//    List<Person> findByLastnameIgnoreCase(String lastname);

    // OrderBy là cách sắp xếp thứ tự trả về
    // Sắp xếp theo Firstname ASC
//    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    // Sắp xếp theo Firstname Desc
//    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
}
