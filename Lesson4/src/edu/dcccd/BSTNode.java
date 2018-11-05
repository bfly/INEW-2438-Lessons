package edu.dcccd;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BSTNode<T>
{
    protected T element;
    protected BSTNode<T> left, right;

    BSTNode(T element)
    {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

